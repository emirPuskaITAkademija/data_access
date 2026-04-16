package com.academy.third.country.persistence;

import com.academy.third.Dao;
import org.hibernate.query.Query;

import java.util.List;

public class CountryDao implements Dao<Country, Integer> {
    @Override
    public Country save(Country country) {
        return execute(session -> {
            Integer id = (Integer) session.save(country);
            country.setCountryId(id);
            session.refresh(country);
            return country;
        });
    }

    @Override
    public List<Country> findAll() {
        return execute(session -> {
            Query<Country> fromCountry = session.createQuery("from Country", Country.class);
            return fromCountry.list();
        });
    }

    @Override
    public Country findById(Integer id) {
        return execute(session -> {
            return session.get(Country.class, id);
        });
    }

    @Override
    public void update(Country country) {
        execute(session -> {
            session.update(country);
            return null;
        });
    }

    @Override
    public void delete(Country entity) {
        execute(session -> {
            session.delete(entity);
            return null;
        });
    }
}
