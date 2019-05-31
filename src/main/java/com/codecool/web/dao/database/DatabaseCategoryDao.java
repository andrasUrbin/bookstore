/*
package com.codecool.web.dao.database;

import com.codecool.web.dao.CategoryDao;
import com.codecool.web.model.Book;
import com.codecool.web.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCategoryDao extends AbstractDao implements CategoryDao {

    DatabaseCategoryDao(Connection connection) {
        super(connection);
    }


    @Override
    public List<Category> findAll() throws SQLException {
        String sql = "SELECT * FROM category";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Category> categories = new ArrayList<>();
            while (resultSet.next()) {
                categories.add(fetchCategory(resultSet));
            }
            return categories;
        }
    }


    @Override
    public Category findCategoryById(int id) throws SQLException {
        String sql = "SELECT * FROM category WHERE id = ?;";
        Category category = new Category(1, "", null);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                category.setName(resultSet.getString("category_name"));
                category.setId(resultSet.getInt("category_id"));
            }
        }
        return category;
    }


    private Category fetchCategory(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("category_id");
        String name = resultSet.getString("category_name");
        List<Book> books = findBooksByCategoryId(id);
        return new Category(id, name);
    }

}
*/
