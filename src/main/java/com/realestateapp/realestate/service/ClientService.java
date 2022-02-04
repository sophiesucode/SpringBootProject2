package com.realestateapp.realestate.service;


import com.realestateapp.realestate.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
}

