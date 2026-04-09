package com.academy.third.show.persistence;

import com.academy.third.Dao;
import com.academy.third.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ShowDao implements Dao<Show, Integer> {
    @Override
    public Show save(Show show) {
        return null;
    }

    @Override
    public List<Show> findAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        //from shows => from Show
        Query<Show> showQuery = session.createQuery("from Show", Show.class);
        List<Show> showList = showQuery.getResultList();
        return showList;
    }

    @Override
    public Show findById(Integer id) {
        return null;
    }

    @Override
    public void update(Show entity) {

    }

    @Override
    public void delete(Show entity) {

    }
}
