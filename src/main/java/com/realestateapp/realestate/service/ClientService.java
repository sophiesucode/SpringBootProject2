package com.realestateapp.realestate.service;


import com.realestateapp.realestate.exceptions.InformationNotFoundException;
import com.realestateapp.realestate.model.Client;
import com.realestateapp.realestate.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client createClient(Client clientObject) {

        Client client = clientRepository.findClientByName(clientObject.getName());
        return clientRepository.save(clientObject);
    }

    public Optional<Client> getClient(Long clientId) {

        Optional<Client> client = clientRepository.findById(clientId);
        if(client.isPresent()){
            return client;
        }else{
            throw new InformationNotFoundException("client with Id " + clientId + " not found");
        }
    }

    public Client updateClient(Long clientId, Client clientObject) {

        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            Client updateClient = clientRepository.findById(clientId).get();
            updateClient.setName(clientObject.getName());
            updateClient.setEmail(clientObject.getEmail());
            updateClient.setPhone(clientObject.getPhone());
            updateClient.setPhone(clientObject.getPhone());
            updateClient.setMessage(clientObject.getMessage());
            return clientRepository.save(updateClient);
        } else {
            throw new InformationNotFoundException("client with id " + clientId + " not found");
        }
    }

        public Optional<Client> deleteClient(Long clientId){

            Optional<Client> client = clientRepository.findById(clientId);
            if(client.isPresent()){
                clientRepository.deleteById(clientId);
                return client;

            }else {
                throw new InformationNotFoundException("client with id " + clientId +" not found");
            }
        }
    }






