package com.codecool.web.servlet;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.dao.database.DatabaseCustomerDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/registration")
public final class RegistrationServlet extends AbstractServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            CustomerDao customerDao = new DatabaseCustomerDao(connection);

            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String fullName = req.getParameter("fullname");
            String address = req.getParameter("address");

            if(!customerDao.isEmailUsed(email)){
                customerDao.addUser(email, password, fullName, address);
            }else{
                sendMessage(resp, HttpServletResponse.SC_NOT_ACCEPTABLE, email);
            }

        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
