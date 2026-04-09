package com.academy.third.execution;

import com.academy.third.country.persistence.Country;
import com.academy.third.country.persistence.CountryDao;

import java.sql.Timestamp;
import java.util.List;

public class ExecutionDemo {
    public static void main(String[] args) {
        CountryDao countryDao = new CountryDao();
//        Country country = new Country();
//        country.setCountry("Tadzikistan");
//        country.setLastUpdate(new Timestamp(System.currentTimeMillis()));

//        System.out.println(country);
//        Country persistedCountry = countryDao.save(country);
//        System.out.println(persistedCountry);
//        Country country = countryDao.findById(2);
//        System.out.println(country);
//        List<Country> countryList = countryDao.findAll();
//        countryList.forEach(System.out::println);
        Country country = countryDao.findById(5);
        countryDao.delete(country);
        countryDao.findAll().forEach(System.out::println);
    }
}
