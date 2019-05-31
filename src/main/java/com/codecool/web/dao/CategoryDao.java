package com.codecool.web.dao;

import com.codecool.web.model.Category;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    List<Category> findAll() throws SQLException;
    Category findCategoryById(int id) throws SQLException;
}
