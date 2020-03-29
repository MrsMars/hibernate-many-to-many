package com.aoher.main;

import com.aoher.model.Cart;
import com.aoher.model.Item;
import com.aoher.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HibernateManyToManyMain {

    private static Logger log = LoggerFactory.getLogger(HibernateManyToManyMain.class);

    public static void main(String[] args) {

        Item iphone = new Item();
        iphone.setPrice(100); iphone.setDescription("iPhone");

        Item ipod = new Item();
        ipod.setPrice(50); ipod.setDescription("iPod");

        Set<Item> items = new HashSet<>();
        items.add(iphone); items.add(ipod);

        Cart cart = new Cart();
        cart.setItems(items);
        cart.setTotal(150);

        Cart cart1 = new Cart();
        Set<Item> items1 = new HashSet<>();
        items1.add(iphone);
        cart1.setItems(items1);
        cart1.setTotal(100);

        SessionFactory sessionFactory = null;
        try{
            sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(cart);
            session.save(cart1);
            log.info("Before committing transaction");
            tx.commit();
            sessionFactory.close();

            log.info(String.format("Cart ID=%s", cart.getId()));
            log.info(String.format("Cart1 ID=%s", cart1.getId()));
            log.info(String.format("Item1 ID=%s", iphone.getId()));
            log.info(String.format("Item2 ID=%s", ipod.getId()));

        }catch(Exception e){
            log.error(String.format("Exception occurred. %s", e.getMessage()));
        }finally{
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                log.info("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }
}
