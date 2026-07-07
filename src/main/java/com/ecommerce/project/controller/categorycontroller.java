package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import com.ecommerce.project.service.CategoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.project.model.Category;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<Category>> getallcategories(){
        List<Category> allCategories = categoryservice.getAllCategories();
        return  new ResponseEntity<>(allCategories,HttpStatus.OK) ;
    }

    @PostMapping("api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryservice.createCategory(category);
        return new ResponseEntity<>("Category added successfully",HttpStatus.OK);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){

        try{
            String status = categoryservice.deleteCategory(categoryId);
//            return new ResponseEntity<>(status, HttpStatus.OK);
//              return ResponseEntity.ok(status);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory
            (@RequestBody Category category,
             @PathVariable Long categoryId){
        try{
            Category savedCategory = categoryservice.updateCategory(category,categoryId);
            return new ResponseEntity<>("category with category id updated"+categoryId,HttpStatus.OK);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}