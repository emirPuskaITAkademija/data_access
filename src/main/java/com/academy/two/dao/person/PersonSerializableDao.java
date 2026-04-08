package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;

import java.io.*;
import java.util.List;

/**
 * Kada smo učili da pišemo/čitamo u/iz fajl rekli smo da to možemo uraditi kako:
 * <li>byte 8bit</li>
 * <li>char 16bit</li>
 * <li>line</li>
 * <li>serijalizujemo/deserijalizujenmo cijeli objekat</li>
 */
public class PersonSerializableDao implements PersonDao {


    @Override
    public List<Person> readAll() throws DaoException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.serial"))){
            return (List<Person>) ois.readObject();
        }catch (Exception e){
            throw new DaoException(e.getMessage());
        }
    }

    /**
     * ? Wildcard Jokerski tipovi
     *
     * ? super
     * ? extends
     * ?
     * @param entities
     * @throws DaoException
     */
    @Override
    public void writeAll(List<Person> entities) throws DaoException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.serial"))) {
            oos.writeObject(entities);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
