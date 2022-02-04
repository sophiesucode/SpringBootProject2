package com.realestateapp.realestate.controller;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.Client;
import com.realestateapp.realestate.service.AgentService;
import com.realestateapp.realestate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService){this.clientService = clientService;}

   @GetMapping(path = "/clients/")
    public List<Client> getClients(){
        System.out.println("calling getClients ==>");
        return clientService.getAllClients();
    }

}
