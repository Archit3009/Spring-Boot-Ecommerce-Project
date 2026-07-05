package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import com.ecommerce.project.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.project.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class categorycontroller {

    private CategoryService categoryservice;

    public categorycontroller(CategoryServiceImpl categoryservice) {
        this.categoryservice = categoryservice;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getallcategories(){
       return categoryservice.getAllCategories();
    }
    @PostMapping("api/public/categories")
    public String createCategory(@RequestBody Category category){
        categoryservice.createCategory(category);
        return "Category added successfully";
    }
}