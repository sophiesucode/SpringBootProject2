package com.realestateapp.realestate.controller;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.Properties;

import com.realestateapp.realestate.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PropertyController {

 private PropertyService propertyService;

 @Autowired
 public void setPropertyService(PropertyService propertyService){this.propertyService = propertyService;}


   @GetMapping(path = "/hello/")
    public String getHello() {
       return "Hello World";
   }

    @GetMapping(path = "/properties/")
    public List<Properties> getProperties(){
     System.out.println("calling getProperties ==>");
        return propertyService.getAllProperties();
    }

    @GetMapping("/properties/{propertiesId}")
    public Optional getProperties(@PathVariable Long propertiesId){
        System.out.println(("calling getProperties ==>"));
        return propertyService.getProperties(propertiesId);
    }

    @PostMapping("/properties/")
   public Properties createProperty(@RequestBody Properties propertiesObject){
      System.out.println("calling createProperty ==>");
       return propertyService.createProperty(propertiesObject);
   }

    @PutMapping("/properties/{propertiesId}")
   public Properties updateProperties(@PathVariable(value = "propertiesId") Long propertiesId, @RequestBody Properties propertiesObject) {
        System.out.println("calling updateProperty ==>");
       return propertyService.updateProperties(propertiesId, propertiesObject);
    }

    @DeleteMapping("/properties/{propertiesId}")
   public Optional<Properties> deleteProperties(@PathVariable(value = "propertiesId") Long propertiesId) {
        System.out.println("calling deleteProperties ==>");
        return propertyService.deleteProperties(propertiesId);
    }

    public PropertyService getPropertyService() {
        return propertyService;
    }


}







/*
get property by type/find by
get property by id
get property by status
get property by neighborhood/zipcode/address

post: create new property
update property



*/
