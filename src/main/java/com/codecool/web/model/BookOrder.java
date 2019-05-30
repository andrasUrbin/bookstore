package com.codecool.web.model;

import java.sql.Date;
import java.util.Set;

public class BookOrder extends AbstractModel {

    private Customer customer;
    private Date orderDate;
    private String shippingAddress;
    private Set<OrderDetail> orderDetails;

    public BookOrder(int id, Customer customer, Date orderDate, String shippingAddress, Set<OrderDetail> orderDetails) {
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

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
