package com.realestateapp.realestate.controller;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.Client;
import com.realestateapp.realestate.service.AgentService;
import com.realestateapp.realestate.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/clients/{clientId}")
    public Optional getClients(@PathVariable Long clientId){
      System.out.println(("calling getClient ==>"));
       return clientService.getClient(clientId);
   }

    @PostMapping("/clients/")
    public Client createClient(@RequestBody Client clientObject){
        System.out.println("calling createClient ==>");
        return clientService.createClient(clientObject);
    }

    @PutMapping("/clients/{clientId}")
    public Client updateClient(@PathVariable(value = "clientId") Long clientId, @RequestBody Client clientOject) {
        System.out.println("calling updateclient ==>");
        return clientService.updateClient(clientId, clientOject);
    }

    @DeleteMapping("/clients/{clientId}")
    public Optional<Client> deleteClient(@PathVariable(value = "clientId") Long clientId) {
        System.out.println("calling deleteClient ==>");
        return clientService.deleteClient(clientId);
    }
}
