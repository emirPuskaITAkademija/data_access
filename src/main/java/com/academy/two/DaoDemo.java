package com.academy.two;

import com.academy.two.dao.DaoException;
import com.academy.two.dao.person.*;
import com.academy.two.model.Person;

import java.util.List;

public class DaoDemo {
    public static void main(String[] args) throws DaoException {
        PersonDao personDao = new PersonCsvDao();
        List<Person> personList = personDao.readAll();
//        for(Person person : personList){
//            System.out.println(person);
//        }
        personList.removeFirst();
//        personList.add(new Person("Stefan", "Bantić", "3444", 34));
//        personDao.writeAll(personList);
        personDao = new PersonSqlDao();
        personDao.writeAll(personList);
//        for(Person person : personDao.readAll()){
//            System.out.println(person);
//        }
    }
}
