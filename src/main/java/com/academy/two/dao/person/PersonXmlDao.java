package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * {@link java.beans.XMLEncoder}
 * {@link java.beans.XMLDecoder}
 *
 */
public class PersonXmlDao implements PersonDao {

    @Override
    public List<Person> readAll() throws DaoException {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("persons.xml"))) {
            List<Person> readedList = (List<Person>) xmlDecoder.readObject();
            return readedList;
        } catch (IOException e) {
            throw new DaoException("PersonXMLDao read: %s".formatted(e.getMessage()));
        }
    }

    @Override
    public void writeAll(List<Person> entities) throws DaoException {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream("persons.xml"))) {
            encoder.writeObject(entities);
        } catch (IOException exception) {
            throw new DaoException("PersonsXMLDao write: %s".formatted(exception.getMessage()));
        }
    }
}
