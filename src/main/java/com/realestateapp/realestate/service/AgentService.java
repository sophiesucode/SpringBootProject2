package com.realestateapp.realestate.service;

import com.realestateapp.realestate.repository.AgentRepository;
import com.realestateapp.realestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    private AgentRepository agentRepository; //inject repository

    @Autowired //autowire repository to constructor
    public void setAgentRepository(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }


//    public AgentRepository getAgentRepository() {//is this necessary? why ?
//        return agentRepository;
//    }

    private PropertyRepository propertyRepository;

    @Autowired
    public void setPropertyRepository(PropertyRepository propertyRepository){
        this.propertyRepository = propertyRepository;
    }
}

