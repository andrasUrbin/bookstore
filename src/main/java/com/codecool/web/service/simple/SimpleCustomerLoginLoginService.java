package com.codecool.web.service.simple;

import com.codecool.web.dao.CustomerDao;
import com.codecool.web.model.Customer;
import com.codecool.web.service.CustomerLoginService;
import com.codecool.web.service.exception.ServiceException;

import java.sql.SQLException;

public class SimpleCustomerLoginLoginService implements CustomerLoginService {

    private final CustomerDao customerDao;

    public SimpleCustomerLoginLoginService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer loginCustomer(String email, String password) throws SQLException, ServiceException {
        try {
            Customer customer = customerDao.findByEmail(email);
            if (customer == null || !customer.getPassword().equals(password)) {
                throw new ServiceException("Bad login");
            }
            return customer;
        } catch (IllegalArgumentException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
