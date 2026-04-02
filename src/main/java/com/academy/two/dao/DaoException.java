package com.academy.two.dao;

public class DaoException extends Exception{
    public DaoException(String message) {
        super("DAO Exception: '%s'".formatted(message));
    }
}
