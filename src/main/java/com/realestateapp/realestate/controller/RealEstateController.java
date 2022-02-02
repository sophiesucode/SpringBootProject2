package com.realestateapp.realestate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RealEstateController {

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "Hello World";
    }

//    private CategoryService categoryService;
//
//    @Autowired
//    public void setCategoryService(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping("/categories")
//    public List<Category> getCategories() {
//        System.out.println("calling getCategories ==>");
//        return categoryService.getAllCategories();
//    }

}
