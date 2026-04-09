package com.academy.third;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            //otići će do resources/hibernate.cfg.xml i vidjeti koje konfiguracione parametre treba da učita
            // s tim parametrima će kasnije kreirat kad pozovemo funkciju configuration.buildSessionFactory();
            try {
                Configuration configuration = new Configuration();
                configuration.configure();
                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable ex) {
                throw new ExceptionInInitializerError(ex.getMessage());
            }
        }
        return sessionFactory;
    }
}
