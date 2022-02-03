package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Properties, Long> {

    Properties findByCity(String city);

    @Override
    Properties getById(Long aLong);

    Properties findPropertiesByProperty_status(String status);

    Properties findByNeighborhood(String neighborhood);
}
