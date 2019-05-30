package com.codecool.web.servlet;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.dao.database.DatabaseCustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.service.CustomerLoginService;
import com.codecool.web.service.exception.ServiceException;
import com.codecool.web.service.simple.SimpleCustomerLoginLoginService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login-customer")
public final class CustomerLoginServlet extends AbstractServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            CustomerDao customerDao = new DatabaseCustomerDao(connection);
            CustomerLoginService customerLoginService = new SimpleCustomerLoginLoginService(customerDao);

            String email = req.getParameter("email");
            String password = req.getParameter("password");

            Customer customer = customerLoginService.loginCustomer(email, password);
            req.getSession().setAttribute("customer", customer);

            sendMessage(resp, HttpServletResponse.SC_OK, customer);
        } catch (ServiceException ex) {
            sendMessage(resp, HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        } catch (SQLException ex) {
            handleSqlError(resp, ex);
        }
    }
}
