package com.ecommerce.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.project.model.category;

import java.util.ArrayList;
import java.util.List;

@RestController
public class categorycontroller {

    private List<category> categories = new ArrayList<>();
    @GetMapping("/categories")
    public List<category> getallcategories(){

    }

}
