package com.codecool.web.servlet;

import com.codecool.web.dao.BookDao;
import com.codecool.web.dao.database.DatabaseBookDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.Customer;
import com.codecool.web.service.BookService;
import com.codecool.web.service.simple.SimpleBookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/protected/books")
public class BooksServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            BookDao bookDao = new DatabaseBookDao(connection);
            BookService bookService = new SimpleBookService(bookDao);
            //Customer customer = (Customer) req.getSession().getAttribute("customer");
            List<Book> books = bookService.findAll();

            sendMessage(resp, HttpServletResponse.SC_OK, books);

        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }
}
