package com.codecool.web.dao;

import com.codecool.web.model.BookOrder;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {

    List<BookOrder> listAllOrders() throws SQLException;
    BookOrder findOrderById(int id) throws SQLException;
    void addOrder(int customerId, String shippingAddress, String customerName, int priceOfOrder) throws SQLException;
    void modifyOrderStatus() throws SQLException;
}
