package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Properties, Long> {
//    Properties findById(propertiesId);
    Properties findByCity(String city);

    Properties findByStreet(String street);

//    Properties findPropertiesByProperty_type(String property_type); whats wrong with this line?

//    Properties findPropertiesByProperty_status(String status); whats wrong with this line?

    Properties findByNeighborhood(String neighborhood);


}

//    get property by type/find by
//        get property by id
//        get property by status
//        get property by neighborhood/zipcode/address
//
//        post: create new property
//        update property