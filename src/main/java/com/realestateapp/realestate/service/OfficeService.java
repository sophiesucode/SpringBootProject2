package com.realestateapp.realestate.service;

import com.realestateapp.realestate.exceptions.InformationNotFoundException;
import com.realestateapp.realestate.model.Client;
import com.realestateapp.realestate.model.RealEstateOffice;
import com.realestateapp.realestate.repository.AgentRepository;
import com.realestateapp.realestate.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeService {

    private OfficeRepository officeRepository;

    @Autowired
    public void setOfficeRepository(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public OfficeRepository getOfficeRepository() {
        return officeRepository;
    }

    public List<RealEstateOffice> getAllOffices() {
        return officeRepository.findAll();

    }

    public RealEstateOffice createOffice(RealEstateOffice realEstateOfficeObject) {

        RealEstateOffice realEstateOffice = officeRepository.findByAddress(realEstateOfficeObject.getAddress());
        return officeRepository.save(realEstateOfficeObject);
    }

    public Optional<RealEstateOffice> getOffice(Long officeId) {

        Optional<RealEstateOffice> realEstateOffice = officeRepository.findById(officeId);
        if (realEstateOffice.isPresent()) {
            return realEstateOffice;
        } else {
            throw new InformationNotFoundException("office with Id " + officeId + " not found");
        }
    }

    public RealEstateOffice updateOffice(Long officeId, RealEstateOffice realEstateOfficeObject) {

        Optional<RealEstateOffice> realEstateOffice = officeRepository.findById(officeId);
        if (realEstateOffice.isPresent()) {
            RealEstateOffice updateOffice = officeRepository.findById(officeId).get();
            updateOffice.setId(realEstateOfficeObject.getId());
            updateOffice.setName(realEstateOfficeObject.getName());
            updateOffice.setAddress(realEstateOfficeObject.getAddress());
            updateOffice.setEmail(realEstateOfficeObject.getEmail());
            updateOffice.setPhone(realEstateOfficeObject.getPhone());
            return officeRepository.save(updateOffice);
        } else {
            throw new InformationNotFoundException("office with id " + officeId + " not found");
        }
    }


        public Optional<RealEstateOffice> deleteOffice(Long officeId){

            Optional<RealEstateOffice> realEstateOffice = officeRepository.findById(officeId);
            if(realEstateOffice.isPresent()){
                officeRepository.deleteById(officeId);
                return realEstateOffice;

            }else {
                throw new InformationNotFoundException("office with id " + officeId +" not found");
            }
        }

}