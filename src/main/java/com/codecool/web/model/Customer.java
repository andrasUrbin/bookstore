package com.codecool.web.model;

import java.util.List;

public class Customer extends AbstractModel {

    private String email;
    private String password;
    private String fullName;
    private List<Review> reviews;
    private List<Order> orders;
    private String address;
    private int cashAmount;

    public Customer(int id, String email, String password, String fullName, List<Review> reviews, List<Order> orders, String address, int cashAmount) {
        super(id);
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.reviews = reviews;
        this.orders = orders;
        this.address = address;
        this.cashAmount = cashAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(int cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
