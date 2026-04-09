package com.academy.third;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;
import java.util.function.Function;

/**
 * E - entity
 * PK - kolona/property koje identifikuje jedinstveno red/instancu
 * <p>
 * Create
 * Retrieve
 * Update
 * Delete
 * <p>
 * CRUD
 * </p>
 *
 * @param <E>
 * @param <PK>
 */
public interface Dao<E, PK> {

    // CREATE
    E save(E e);

    //RETRIEVE
    List<E> findAll();

    E findById(PK id);

    // UPDATE
    void update(E entity);

    //DELETE
    void delete(E entity);


    // Function<Session, R>

    /**
     * Princip: Identifikuj dio koda koji se razlikuje i izolujte ga u interface.
     * Function<Session, R> action
     * i kreirajte različite implementacije tog interface-a koje ćete dinamično slati kao objekat
     * zvani action.
     *
     * Session -> List<Country>, Country, Integer(PK)..
     *
     * @param action
     * @return result
     * @param <R>
     */
    default <R> R execute(Function<Session, R> action){
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            R result = action.apply(session);// R List<Country>, Integer, Country
            session.getTransaction().commit();
            return result;
        } catch (HibernateException e) {
            if (session != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
