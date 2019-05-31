package com.codecool.web.model;

import java.util.List;

public class Category extends AbstractModel {

    private String name;
    private List<Book> books;

    public Category(int id, String name, List<Book> books) {
        super(id);
        this.name = name;
        this.books = books;
    }

    public Category(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
