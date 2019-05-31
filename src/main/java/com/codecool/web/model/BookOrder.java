package com.codecool.web.model;

import java.sql.Date;
import java.util.List;

public class BookOrder extends AbstractModel {

    private Customer customer;
    private Date orderDate;
    private String shippingAddress;
    private List<OrderDetail> orderDetails;

    public BookOrder(int id, Customer customer, Date orderDate, String shippingAddress, List<OrderDetail> orderDetails) {
        super(id);
        this.customer = customer;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
