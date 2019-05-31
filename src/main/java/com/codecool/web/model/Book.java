package com.codecool.web.model;

import java.util.List;

public class Book extends AbstractModel {

    private String title;
    private String author;
    private String description;
    private int price;
    private Category category;
    private List<Review> reviews;


    public Book(int id, String title, String author, String description, int price, Category category, List<Review> reviews) {
        super(id);
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
        this.reviews = reviews;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
