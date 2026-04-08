package com.academy.two.dao.person;

import com.academy.two.dao.DaoException;
import com.academy.two.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Dva pristupa rada s relacionom bazom podataka MySQL:
 * <li></li>
 * <li></li>
 */
public class PersonSqlDao implements PersonDao {

    public static final String URL = "jdbc:mysql://localhost:3306/person_db";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    @Override
    public List<Person> readAll() throws DaoException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM persons")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Person> personList = new ArrayList<>();
            while (resultSet.next()) {
                Person person = new Person();
                person.setNationalIdentificationNumber(resultSet.getString("nin"));
                person.setName(resultSet.getString("name"));
                person.setSurname(resultSet.getString("surname"));
                person.setAge(resultSet.getInt("age"));
                personList.add(person);
            }
            return personList;
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }

    //DB transakcija = grupa operacija  koja se izvršava kao JEDNA CJELINA
    // ili svaki insert statement za svaku osobu ili rollback za sve osobe..
    @Override
    public void writeAll(List<Person> personList) throws DaoException {
        String sqlInsert = "INSERT INTO persons (nin, name, surname, age) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);) {
            //1. sam hoću da vodim računa o granicama svoje transakcije
            connection.setAutoCommit(false);
            for (Person person : personList) {
                preparedStatement.setString(1, person.getNationalIdentificationNumber());
                preparedStatement.setString(2, person.getName());
                preparedStatement.setString(3, person.getSurname());
                preparedStatement.setInt(4, person.getAge());

                preparedStatement.addBatch();
            }

            //2. izvrši grupu/batch insert statementa
            preparedStatement.executeBatch();

            //3. ako je sve ok insertuj sve ili rollbackuj na početno stanje
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException(e.getMessage());
        }
    }
}
