package com.realestateapp.realestate.model;

import javax.persistence.*;

@Entity
@Table(name = "real_estate_properties")
public class RealEstateProperties {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String street;

    @Column
    private String city;


    @Column
    private Integer zipcode;

    @Column
    private String state;

    @Column
    private String neighborhood;

    @Column
    private String property_type;

    @Column
    private String description;

    @Column
    private double property_size;

    @Column
    private String list_date;

    @Column
    private Integer num_bedrooms;

    @Column
    private Integer num_bathrooms;

    @Column
    private Boolean hasPool;

    @Column
    private Boolean hasBasement;

    @Column
    private Boolean hasBackyard;

    @Column
    private Boolean hasGarage;

    @Column
    private String property_status;

    //FK will be company id and agent id

   






}
