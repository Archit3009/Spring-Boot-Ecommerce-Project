package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

// it is an interface instead of class to promote loose coupling and modularity
// it will have a declaration of all the methods that we want
//
public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
    Category updateCategory(Category category,Long categoryId);
}
