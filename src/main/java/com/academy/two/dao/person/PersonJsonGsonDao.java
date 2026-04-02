package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class PersonJsonGsonDao implements PersonDao {
    public static final String PERSONS_JSON = "persons-gson.json";

    private final Gson gson = new Gson();

    @Override
    public List<Person> readAll() throws DaoException {
        try(FileReader fileReader = new FileReader("persons-gson.json")){
            Type parametriziraniListType = new TypeToken<List<Person>>(){}.getType();
            //persons-gson.json -> jsonString -> type konverziju u List<Person>
            return gson.fromJson(fileReader, parametriziraniListType);
        }catch (IOException e){
            throw new DaoException(e.getMessage());
        }
    }

    @Override
    public void writeAll(List<Person> personList) throws DaoException {
        try(FileWriter out = new FileWriter("persons-gson.json")) {
            //personList -> jsonString -> out
            gson.toJson(personList, out);
        } catch (IOException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
