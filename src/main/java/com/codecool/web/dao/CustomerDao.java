package com.codecool.web.dao;

import com.codecool.web.model.BookOrder;
import com.codecool.web.model.Customer;
import com.codecool.web.model.Review;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface CustomerDao {

    List<Customer> findAll() throws SQLException;
    Customer findByEmail(String email) throws SQLException;
    void add(int id, String email, String password, String fullName, Set<Review> reviews, Set<BookOrder> bookOrders, String address, int cashAmount) throws SQLException;
}
