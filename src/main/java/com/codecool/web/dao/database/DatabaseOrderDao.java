package com.codecool.web.dao.database;

import com.codecool.web.dao.OrderDao;
import com.codecool.web.model.BookOrder;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOrderDao extends AbstractDao implements OrderDao {

    public DatabaseOrderDao(Connection connection) {
        super(connection);
    }

    @Override
    public List<BookOrder> listAllOrders() throws SQLException {
        String sql = "SELECT * FROM book_order";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<BookOrder> bookOrders = new ArrayList<>();
            while (resultSet.next()) {
                bookOrders.add(fetchBookOrders(resultSet));
            }
            return bookOrders;
        }
    }

    @Override
    public BookOrder findOrderById(int id) throws SQLException {
        return null;
    }

    @Override
    public void addOrder(int customerId, String shippingAddress, String customerName, int priceOfOrder) throws SQLException {

    }

    @Override
    public void modifyOrderStatus() throws SQLException {

    }

    private BookOrder fetchBookOrders(ResultSet resultSet) throws SQLException{

    }
}
