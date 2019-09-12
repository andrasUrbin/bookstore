package com.codecool.web.dao;

import com.codecool.web.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> findAll() throws SQLException;
    Book findBookById(int id) throws SQLException;
    void addBook(String title, String author, String desc, int price, int categoryId) throws SQLException;
}
