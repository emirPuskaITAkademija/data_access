package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class PersonJsonSimpleDao implements PersonDao {
    private static final String FILENAME = "persons.json";

    @Override
    public List<Person> readAll() throws DaoException {
        return List.of();
    }

    @Override
    public void writeAll(List<Person> entities) throws DaoException {
        JSONArray jsonArray = new JSONArray();
        for (Person person : entities) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", person.getName());
            jsonObject.put("surname", person.getSurname());
            jsonObject.put("nationalIdentificationNumber", person.getNationalIdentificationNumber());
            jsonObject.put("age", person.getAge());
            jsonArray.add(jsonObject);
        }
        String jsonString = jsonArray.toJSONString();
        try (FileWriter out = new FileWriter(FILENAME)) {
            out.write(jsonString);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
