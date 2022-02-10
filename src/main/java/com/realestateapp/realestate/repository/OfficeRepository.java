package com.realestateapp.realestate.repository;


import com.realestateapp.realestate.model.RealEstateOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository< RealEstateOffice, Long> {
    RealEstateOffice findByAddress(String address);


}
