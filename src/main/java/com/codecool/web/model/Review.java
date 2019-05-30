package com.codecool.web.model;

public class Review extends AbstractModel{

    private String headline;
    private String comment;
    private int rating;
    private Book book;
    private Customer customer;

    public Review(int id, String headline, String comment, int rating, Book book, Customer customer) {
        super(id);
        this.headline = headline;
        this.comment = comment;
        this.rating = rating;
        this.book = book;
        this.customer = customer;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
