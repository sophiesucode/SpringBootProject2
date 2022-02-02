package com.realestateapp.realestate.model;

import javax.persistence.*;

@Entity
@Table(name="agents")
public class RealEstateAgent {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // should this be agent_id instead to match chart?

    @Column
    private String name;


    //add email address ?

    //foreign key will be company id

   public RealEstateAgent(){

   }

    @Override
    public String toString() {
        return "RealEstateAgent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public RealEstateAgent(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
