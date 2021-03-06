package com.codecool.web.servlet;

import com.codecool.web.dao.BookDao;
import com.codecool.web.dao.database.DatabaseBookDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.Customer;
import com.codecool.web.service.BookService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleBookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())){
            BookDao bookDao = new DatabaseBookDao(connection);
            BookService bookService = new SimpleBookService(bookDao);

            int bookId = Integer.parseInt(req.getParameter("id"));
            //Customer customer = (Customer) req.getSession().getAttribute("customer");
            Book book = bookService.findBookById(bookId);

            sendMessage(resp, HttpServletResponse.SC_OK, book);

        } catch (SQLException e) {
            handleSqlError(resp, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            BookDao bookDao = new DatabaseBookDao(connection);
            BookService bookService = new SimpleBookService(bookDao);

            String title = req.getParameter("title");
            String author = req.getParameter("author");
            String desc = req.getParameter("desc");
            int price = Integer.parseInt(req.getParameter("price"));
            int categoryId = Integer.parseInt(req.getParameter("category_id"));
            bookService.addBook(title, author, desc, price, categoryId);
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
