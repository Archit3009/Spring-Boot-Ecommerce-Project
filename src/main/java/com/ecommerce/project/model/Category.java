package com.ecommerce.project.model;

public class Category {
    private Long categoryId;
    private String categoryname;

    public Category(Long categoryId, String categoryname) {
        this.categoryId = categoryId;
        this.categoryname = categoryname;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }
}
