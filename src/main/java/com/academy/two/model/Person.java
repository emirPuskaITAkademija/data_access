package com.academy.two.model;

import java.io.Serializable;

/**
 * POJO vs Java Bean
 */
public class Person implements Serializable {

    private String nationalIdentificationNumber;
    private String name;
    private String surname;
    private int age;

    public Person() {
    }

    public Person(String name, String surname, String nationalIdentificationNumber, int age) {
        this.name = name;
        this.surname = surname;
        this.nationalIdentificationNumber = nationalIdentificationNumber;
        this.age = age;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "%s  %s , age = %s, nin = %s".formatted(name, surname, age, nationalIdentificationNumber);
//        return name + " " + surname + ", age = " + age + ", nin = " + nationalIdentificationNumber;
    }
}
