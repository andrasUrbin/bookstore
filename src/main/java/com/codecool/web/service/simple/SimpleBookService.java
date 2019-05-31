package com.codecool.web.service.simple;

import com.codecool.web.dao.BookDao;
import com.codecool.web.model.Book;
import com.codecool.web.service.BookService;

import java.sql.SQLException;
import java.util.List;

public class SimpleBookService implements BookService {

    private final BookDao bookDao;

    public SimpleBookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    
    @Override
    public List<Book> findAll() throws SQLException {
        return bookDao.findAll();
    }
}
