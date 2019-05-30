package com.codecool.web.dao.database;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.BookOrder;
import com.codecool.web.model.Customer;
import com.codecool.web.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DatabaseCustomerDao extends AbstractDao implements CustomerDao {

    public DatabaseCustomerDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        String sql = "SELECT * FROM customer";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(fetchCustomer(resultSet));
            }
            return customers;
        }
    }

    @Override
    public Customer findByEmail(String email) throws SQLException {
        if (email == null || "".equals(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        String sql = "SELECT * FROM customer WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return fetchCustomer(resultSet);
                }
            }
        }
        return null;
    }

    @Override
    public void add(int id, String email, String password, String fullName, Set<Review> reviews, Set<BookOrder> bookOrders, String address, int cashAmount) throws SQLException {
        String sql = "INSERT INTO customer(email, password, full_name) VALUES(?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(2, email);
            statement.setString(3,  password);
            statement.setString(4, fullName);
            statement.execute();

        }
    }

    private Customer fetchCustomer(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("customer_id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String fullName = resultSet.getString("fullname");
        Set<Review> review = null;
        Set<BookOrder> bookOrders = null;
        String address = resultSet.getString("address");
        int cashAmount = resultSet.getInt("cash_amount");
        return new Customer(id, email, password, fullName, review, bookOrders, address, cashAmount);
    }
}