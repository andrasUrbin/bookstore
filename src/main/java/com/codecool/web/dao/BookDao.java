package com.codecool.web.dao;

import com.codecool.web.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> findAll() throws SQLException;
}
