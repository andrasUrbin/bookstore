package com.codecool.web.model;

public class Review extends AbstractModel{

    private String headline;
    private String comment;
    private int rating;
    private int bookId;
    private int customerId;

    public Review(int id, String headline, String comment, int rating, int bookId, int customerId) {
        super(id);
        this.headline = headline;
        this.comment = comment;
        this.rating = rating;
        this.bookId = bookId;
        this.customerId = customerId;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
