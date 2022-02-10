package com.realestateapp.realestate.service;

import com.realestateapp.realestate.exceptions.InformationExistException;
import com.realestateapp.realestate.exceptions.InformationNotFoundException;
import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.Properties;
import com.realestateapp.realestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyService {


    private PropertyRepository propertyRepository;

    @Autowired
    public void setPropertyRepository(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }


    public List<Properties> getAllProperties(){
        return propertyRepository.findAll();
    }


    public Properties createProperty(Properties propertiesObject){

        Properties properties = propertyRepository.findByStreet(propertiesObject.getStreet());

        if(properties !=null){
            throw new InformationExistException(("Property located at " + properties.getStreet() + " already exists"));
        }else {
            return propertyRepository.save(propertiesObject);
        }
    }

    public Optional<Properties> getProperties(Long propertiesId) {

        Optional<Properties> properties = propertyRepository.findById(propertiesId);
        if(properties.isPresent()){
            return properties;
        }else{
            throw new InformationNotFoundException("property with Id " + propertiesId + " not found");
        }
    }

    public Properties updateProperties(Long propertiesId, Properties propertiesObject){

        Optional<Properties> properties = propertyRepository.findById(propertiesId);
        if(properties.isPresent()){
            Properties updateProperties = propertyRepository.findById(propertiesId).get();
            updateProperties.setStreet(propertiesObject.getStreet());
            updateProperties.setCity(propertiesObject.getCity());
            updateProperties.setZipcode(propertiesObject.getZipcode());
            updateProperties.setState(propertiesObject.getState());
            updateProperties.setNeighborhood(propertiesObject.getNeighborhood());
            updateProperties.setProperty_type(propertiesObject.getProperty_type());
            updateProperties.setDescription(propertiesObject.getDescription());
            updateProperties.setProperty_size(propertiesObject.getProperty_size());
            updateProperties.setList_date(propertiesObject.getList_date());
            updateProperties.setNum_bedrooms(propertiesObject.getNum_bedrooms());
            updateProperties.setNum_bathrooms(propertiesObject.getNum_bathrooms());
            updateProperties.setHasPool(propertiesObject.getHasPool());
            updateProperties.setHasBasement(propertiesObject.getHasBasement());
            updateProperties.setHasBackyard(propertiesObject.getHasBackyard());
            updateProperties.setHasGarage(propertiesObject.getHasGarage());
            updateProperties.setProperty_status(propertiesObject.getProperty_status());

                //be able to set agent/assign agent

//
//

//
//            updateProperties.setId(propertiesObject.getId());
            updateProperties.setAgent(propertiesObject.getAgent());
            return propertyRepository.save(updateProperties);
        }else{
            throw new InformationNotFoundException("property with id " + propertiesId + " not found");
        }
    }

    public Optional<Properties> deleteProperties(Long propertiesId){

        Optional<Properties> properties = propertyRepository.findById(propertiesId);
        if(properties.isPresent()){
            propertyRepository.deleteById(propertiesId);
            return properties;

        }else{
            throw new InformationNotFoundException("property with id " + propertiesId +" not found");
        }
    }


}
