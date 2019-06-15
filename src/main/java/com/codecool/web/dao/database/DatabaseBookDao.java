package com.codecool.web.dao.database;

import com.codecool.web.dao.BookDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.Category;
import com.codecool.web.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBookDao extends AbstractDao implements BookDao {

    public DatabaseBookDao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Book> findAll() throws SQLException {
        String sql = "SELECT * FROM book \n" +
            "INNER JOIN category \n" +
            "\tON (book.category_id = category.category_id) \n" +
            "FULL JOIN review \n" +
            "\ton (book.book_id = review.book_id);";
        List<Book> books = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                books.add(fetchBook(resultSet));
            }
            return books;
        }
    }

    @Override
    public Book findBookById(int id) throws SQLException {
        String sql = "select * from book \n" +
            "\tinner join category\n" +
            "\t\ton (book.category_id = category.category_id)\n" +
            "\tfull join review\n" +
            "\t\ton (book.book_id = review.book_id)\n" +
            "where book.book_id = ?;";
        Book book = null;
        try(PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    book = fetchBook(resultSet);
                }
            }
        }
        return book;
    }

    private Book fetchBook(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("book_id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String description = resultSet.getString("description");
        int price = resultSet.getInt("price");
        int categoryId = resultSet.getInt("category_id");
        String categoryName = resultSet.getString("category_name");
        Category category = new Category(categoryId, categoryName);
        List<Review> reviews = new ArrayList<>();
        String sql = "SELECT * FROM book \n" +
            "INNER JOIN category \n" +
            "\tON (book.category_id = category.category_id) \n" +
            "FULL JOIN review \n" +
            "\ton (book.book_id = review.book_id);";
        try (Statement statement = connection.createStatement();
             ResultSet resultSetReview = statement.executeQuery(sql)){
            while(resultSetReview.next()){
                int reviewId = resultSet.getInt("review_id");
                int customerId = resultSet.getInt("customer_id");
                int rating = resultSet.getInt("rating");
                String headline = resultSet.getString("headline");
                String comment = resultSet.getString("comment");
                Review review = new Review(reviewId, headline, comment, rating, id, customerId);
                if(!reviews.contains(review)){
                reviews.add(review);
                }
            }
        }
        return new Book(id, title, author, description, price, category, reviews);
    }
}
