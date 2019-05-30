package com.codecool.web.model;

import java.util.Set;

public class Customer extends AbstractModel {

    private String email;
    private String password;
    private String fullName;
    private Set<Review> reviews;
    private Set<BookOrder> bookOrders;
    private String address;
    private int cashAmount;

    public Customer(int id, String email, String password, String fullName, Set<Review> reviews, Set<BookOrder> bookOrders, String address, int cashAmount) {
        super(id);
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.reviews = reviews;
        this.bookOrders = bookOrders;
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

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<BookOrder> getBookOrders() {
        return bookOrders;
    }

    public void setBookOrders(Set<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }
}
