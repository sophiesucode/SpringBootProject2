package com.realestateapp.realestate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class RealEstateController {

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/agents/")
            public String getAgents() {
            return "get all agents";
            }



     @GetMapping("/agents/{agentId}")
    public String getAgents(@PathVariable Long id){
        return "getting agent with id: " + id;
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
