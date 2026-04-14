package com.academy.five.active_record;

import com.academy.third.HibernateUtil;
import com.academy.third.SessionAction;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractActiveRecord<E, PK> {

    protected <V> V executeSessionAction(SessionAction<V> sessionAction) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            V value = sessionAction.execute(session);
            session.getTransaction().commit();
            return value;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public E save() {
        SessionAction<E> saveAction = session -> {
            session.save(this);
            return (E) this;
        };
        return executeSessionAction(saveAction);
    }

    public void update() {
        SessionAction<E> updateAction = session -> {
            session.update(this);
            return null;
        };
        executeSessionAction(updateAction);
    }

}
