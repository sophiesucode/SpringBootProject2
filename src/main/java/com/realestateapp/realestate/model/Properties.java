package com.realestateapp.realestate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "real_estate_properties")
public class Properties {

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "office_id")
    private RealEstateOffice realEstateOffice;

    @Override
    public String toString() {
        return "RealEstateProperties{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", state='" + state + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", property_type='" + property_type + '\'' +
                ", description='" + description + '\'' +
                ", property_size=" + property_size +
                ", list_date='" + list_date + '\'' +
                ", num_bedrooms=" + num_bedrooms +
                ", num_bathrooms=" + num_bathrooms +
                ", hasPool=" + hasPool +
                ", hasBasement=" + hasBasement +
                ", hasBackyard=" + hasBackyard +
                ", hasGarage=" + hasGarage +
                ", property_status='" + property_status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getProperty_type() {
        return property_type;
    }

    public void setProperty_type(String property_type) {
        this.property_type = property_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getProperty_size() {
        return property_size;
    }

    public void setProperty_size(double property_size) {
        this.property_size = property_size;
    }

    public String getList_date() {
        return list_date;
    }

    public void setList_date(String list_date) {
        this.list_date = list_date;
    }

    public Integer getNum_bedrooms() {
        return num_bedrooms;
    }

    public void setNum_bedrooms(Integer num_bedrooms) {
        this.num_bedrooms = num_bedrooms;
    }

    public Integer getNum_bathrooms() {
        return num_bathrooms;
    }

    public void setNum_bathrooms(Integer num_bathrooms) {
        this.num_bathrooms = num_bathrooms;
    }

    public Boolean getHasPool() {
        return hasPool;
    }

    public void setHasPool(Boolean hasPool) {
        this.hasPool = hasPool;
    }

    public Boolean getHasBasement() {
        return hasBasement;
    }

    public void setHasBasement(Boolean hasBasement) {
        this.hasBasement = hasBasement;
    }

    public Boolean getHasBackyard() {
        return hasBackyard;
    }

    public void setHasBackyard(Boolean hasBackyard) {
        this.hasBackyard = hasBackyard;
    }

    public Boolean getHasGarage() {
        return hasGarage;
    }

    public void setHasGarage(Boolean hasGarage) {
        this.hasGarage = hasGarage;
    }

    public String getProperty_status() {
        return property_status;
    }

    public void setProperty_status(String property_status) {
        this.property_status = property_status;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {this.agent= agent;
    }

    public RealEstateOffice getRealEstateOffice() {
        return realEstateOffice;
    }

    public void setRealEstateOffice(RealEstateOffice realEstateOffice) {
        this.realEstateOffice = realEstateOffice;
    }

    public Optional<Object> stream() {
        return stream();
    }
}
