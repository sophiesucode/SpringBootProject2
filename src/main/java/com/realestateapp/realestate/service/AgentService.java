package com.realestateapp.realestate.service;

import com.realestateapp.realestate.exceptions.InformationExistException;
import com.realestateapp.realestate.exceptions.InformationNotFoundException;
import com.realestateapp.realestate.model.Agent;

import com.realestateapp.realestate.model.Properties;
import com.realestateapp.realestate.repository.AgentRepository;

import com.realestateapp.realestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AgentService {

    private AgentRepository agentRepository; //inject repository

    @Autowired //autowire repository to constructor
    public void setAgentRepository(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    private PropertyRepository propertyRepository;

    @Autowired
    public void setPropertyRepository(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }


    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent createAgent(Agent agentObject) {

        Agent agent = agentRepository.findAgentsByName(agentObject.getName());
        if (agent != null) {
            throw new InformationExistException("Agent with name " + agent.getName() + " already exists");
        } else {
            return agentRepository.save(agentObject);
        }
    }

    public Optional<Agent> getAgent(Long agentId) {

        Optional<Agent> agent = agentRepository.findById(agentId);
        if (agent.isPresent()) {
            return agent;
        } else {
            throw new InformationNotFoundException("agent with Id " + agentId + " not found");
        }
    }

    public Agent updateAgent(Long agentId, Agent agentObject) {

        Optional<Agent> agent = agentRepository.findById(agentId);
        if (agent.isPresent()) {
            Agent updateAgent = agentRepository.findById(agentId).get();
            updateAgent.setName(agentObject.getName());
            return agentRepository.save(updateAgent);
        } else {
            throw new InformationNotFoundException("agent with id " + agentId + " not found");
        }
    }

    public Optional<Agent> deleteAgent(Long agentId) {

        Optional<Agent> agent = agentRepository.findById(agentId);
        if (agent.isPresent()) {
            agentRepository.deleteById(agentId);
            return agent;

        } else {
            throw new InformationNotFoundException("agent with id " + agentId + " not found");
        }
    }

    public Properties createAgentProperties(Long agentId, Properties propertiesObject) {

        System.out.println("service calling createAgentProperties ==>");
        try {
            Optional agent = agentRepository.findById(agentId);
            propertiesObject.setAgent((Agent) agent.get());
            return propertyRepository.save(propertiesObject);
        } catch (NoSuchElementException e) {
            throw new InformationNotFoundException("agent with id " + agentId + " not found");
        }
    }


    public List<Properties> getAgentProperties(Long agentId) {
        System.out.println("service calling getCategoryProperties ==>");
        Optional<Agent> agent = agentRepository.findById(agentId);
        if (agent.isPresent()) {
            return agent.get().getPropertiesList();
        } else {
            throw new InformationNotFoundException("category with id " + agentId + " not found");
        }


    }

    public Properties getPropertiesById(Long agentId, Long propertiesId) {
        Agent agent = agentRepository.getById(agentId);
        Properties properties = propertyRepository.getPropertiesByIdAndAgent_Id(propertiesId, agentId);
        if (properties != null) {
            return properties;
        } else {
            throw new InformationNotFoundException("property with id " + propertiesId + " not found.");
        }
    }

    public Properties deleteAgentProperties(Long agentId, Long propertiesId) {
        Agent agent = agentRepository.findById(agentId).get();
        for (Properties properties : agent.getPropertiesList()) {
            if (properties.getId() == propertiesId) {
                // get the current property
                Properties property = propertyRepository.getById(propertiesId);
                // delete property belongs to the agent

                property.setAgent(null);
                propertyRepository.save(property);

                agentRepository.save(agent);
                return property;
            }
        }
        throw new InformationNotFoundException("property with id " + propertiesId + " not found");
    }

}


