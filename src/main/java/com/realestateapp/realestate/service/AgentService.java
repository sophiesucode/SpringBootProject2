package com.realestateapp.realestate.service;

import com.realestateapp.realestate.exceptions.InformationExistException;
import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.repository.AgentRepository;
import com.realestateapp.realestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Agent> getAllAgents(){
        return agentRepository.findAll();
    }

    public Agent createAgent(Agent agentObject){

        Agent agent = agentRepository.findAgentsByName(agentObject.getName());
        if(agent != null) {
            throw new InformationExistException("Agent with name " + agent.getName() + " already exists");
        }else {
            return agentRepository.save(agentObject);
        }
    }
}

