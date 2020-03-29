package com.aoher.main;

import com.aoher.model.Cart1;
import com.aoher.model.Item1;
import com.aoher.util.HibernateAnnotationUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

public class HibernateManyToManyAnnotationMain {

    private static Logger log = LoggerFactory.getLogger(HibernateManyToManyAnnotationMain.class);

    public static void main(String[] args) {
        Item1 item1 = new Item1();
        item1.setDescription("samsung"); item1.setPrice(300);
        Item1 item2 = new Item1();
        item2.setDescription("nokia"); item2.setPrice(200);
        Cart1 cart = new Cart1();
        cart.setTotal(500);
        Set<Item1> items = new HashSet<>();
        items.add(item1); items.add(item2);
        cart.setItems(items);

        SessionFactory sessionFactory = null;
        try{
            sessionFactory = HibernateAnnotationUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            session.save(cart);
            log.info("Before committing transaction");
            tx.commit();
            sessionFactory.close();

            log.info(String.format("Cart ID=%s", cart.getId()));
            log.info(String.format("Item1 ID=%s", item1.getId()));
            log.info(String.format("Item2 ID=%s", item2.getId()));

        }catch(Exception e){
            log.error(String.format("Exception occurred. %s", e.getMessage()));
        }finally{
            if (sessionFactory != null && !sessionFactory.isClosed()) {
                log.info("Closing SessionFactory");
                sessionFactory.close();
            }}
    }

}
