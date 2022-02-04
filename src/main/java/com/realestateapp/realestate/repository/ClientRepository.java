package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByName(String name);
}
