package com.academy.two.dao;

import java.util.List;

public interface Dao<E> {

    /**
     * <p>
     * Ova metoda treba da pročita trajno snimljene informacije o entitetima i da nam
     * vrati listu učitanih entiteta
     * </p>
     *
     * @return list of entities instances/objects
     * @throws DaoException
     */
    List<E> readAll() throws DaoException;

    /**
     * <p>
     *     Ova metoda treba da snimi entitete koje je dobila kroz parametar entities,
     *     koji predstavlja listu entiteta skladištenih u kolekciji List.
     * </p>
     * @param entities
     * @throws DaoException
     */
    void writeAll(List<E> entities) throws DaoException;
}
