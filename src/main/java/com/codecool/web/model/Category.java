package com.codecool.web.model;

import java.util.Set;

public class Category extends AbstractModel {

    private String name;
    private Set<Book> books;

    public Category(int id, String name, Set<Book> books) {
        super(id);
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
