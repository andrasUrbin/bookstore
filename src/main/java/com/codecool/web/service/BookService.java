package com.codecool.web.service;

import com.codecool.web.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookService {
    List<Book> findAll() throws SQLException;
    Book findBookById(int id) throws SQLException;
    void addBook(String title, String author, String desc, int price, int categoryId) throws SQLException;
}
