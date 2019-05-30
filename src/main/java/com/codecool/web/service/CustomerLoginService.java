package com.codecool.web.service;

import com.codecool.web.model.Customer;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public interface CustomerLoginService {

    Customer loginCustomer(String email, String password) throws SQLException, ServiceException;

}
