package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PersonTxtDao implements PersonDao {
    private static final String FILENAME = "persons.txt";

    /**
     * <p>
     * java.io -> Closable .. close
     * BufferedReader br
     * FileReader..
     * </p>
     *
     * @return entities
     * @throws DaoException
     */
    @Override
    public List<Person> readAll() throws DaoException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILENAME))) {
            List<Person> personList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //Luka;Horvat;811;24
                StringTokenizer tokenizer = new StringTokenizer(line, ";");
                String name = tokenizer.nextToken();
                String surname = tokenizer.nextToken();
                String nin = tokenizer.nextToken();
                int age = Integer.parseInt(tokenizer.nextToken());

                Person person = new Person(name, surname, nin, age);
                personList.add(person);
            }
            return personList;
        } catch (IOException exception) {
            throw new DaoException(exception.getMessage());
        }
    }

    /**
     * java.io
     * <p>
     * PrintWriter
     * FileWriter
     * </p>
     *
     * @param entities
     * @throws DaoException
     */
    @Override
    public void writeAll(List<Person> entities) throws DaoException {
        if (entities == null || entities.size() == 0)
            return;
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Person person : entities) {
                String formattedLine = """
                        %s;%s;%s;%s
                        """.formatted(
                        person.getName(),
                        person.getSurname(),
                        person.getNationalIdentificationNumber(),
                        person.getAge());
                writer.print(formattedLine);
            }
        } catch (IOException exception) {
            throw new DaoException(exception.getMessage());
        }
    }
}
