package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Properties, Long> {

    Properties findByCity(String city);

    Properties findByStreet(String street);

    Properties getPropertiesByIdAndAgent_Id(Long propertiesId , Long agentId);

    Properties getPropertiesByRealEstateOfficeId(Long officeId);

    Properties getPropertiesById(Long propertiesId);

    Properties findByNeighborhood(String neighborhood);

}
