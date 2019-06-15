package com.codecool.web.dao;

import com.codecool.web.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {

    List<Customer> findAll() throws SQLException;
    Customer findByEmail(String email) throws SQLException;
    void addUser(String email, String password, String fullName, String address) throws SQLException;
    boolean isEmailUsed(String email) throws SQLException;
}
