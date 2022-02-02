package com.realestateapp.realestate.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AgentController {

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

    @PostMapping("/agents/")
    public String createAgent(@RequestBody String body){
        return "creating new agent " + body;
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
//    @PostMapping("/categories/")
//    public String createCategory(@RequestBody String body) {
//        return "creating a category " + body;
//    }