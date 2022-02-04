package com.realestateapp.realestate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="agents")
public class Agent {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // should this be agent_id instead to match chart?

    @Column
    private String name;

    @OneToMany(mappedBy = "agent", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Properties> properties;




//    @Column
//    private String home_phone;
//
//    @Column
//    private String email;



    //add email address ?
    //

    //foreign key will be company id/office id(which office are they in)

   public Agent(){

   }

    @Override
    public String toString() {
        return "RealEstateAgent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Agent(Long id, String name) {
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
