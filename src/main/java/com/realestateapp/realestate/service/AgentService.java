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
    public void setAgentRepository(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
    }

private PropertyRepository propertyRepository;

    @Autowired
    public void setPropertyRepository(PropertyRepository propertyRepository){
        this.propertyRepository=propertyRepository;
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

    public Optional<Agent> getAgent(Long agentId){

        Optional<Agent> agent = agentRepository.findById(agentId);
        if(agent.isPresent()){
            return agent;
        }else{
            throw new InformationNotFoundException("agent with Id " + agentId + " not found");
        }
    }

    public Agent updateAgent(Long agentId, Agent agentObject){

        Optional <Agent> agent = agentRepository.findById(agentId);
        if(agent.isPresent()){
            Agent updateAgent = agentRepository.findById(agentId).get();
            updateAgent.setName(agentObject.getName());
            return agentRepository.save(updateAgent);
        }else {
            throw new InformationNotFoundException("agent with id " + agentId + " not found");
        }
    }

    public Optional<Agent> deleteAgent(Long agentId){

        Optional<Agent> agent = agentRepository.findById(agentId);
        if(agent.isPresent()){
            agentRepository.deleteById(agentId);
            return agent;

        }else {
            throw new InformationNotFoundException("agent with id " + agentId +" not found");
        }
    }

        public Properties createAgentProperties(Long agentId, Properties propertiesObject) {
            //if problem with this , check last method/line in properties model
            System.out.println("service calling createAgentProperties ==>");
            try {
                Optional agent = agentRepository.findById(agentId);
                propertiesObject.setAgent((Agent) agent.get());
                return propertyRepository.save(propertiesObject);
            } catch (NoSuchElementException e) {
                throw new InformationNotFoundException("agent with id " + agentId + " not found");
            }
        }
//    public Agent createAgentProperties(Long agentId, Properties propertiesObject){
//        Optional<Agent> Agent = agentRepository.findById(agentId);
//        propertiesObject.setAgent(agent.get());
//        return propertyRepository.save(propertiesObject);
//    }
////////////////// need to be able to assign an agent a property by id that already exists in the database
 //in the recipes app a new recipe was added directly to a category by creating the recipe but not this case
            public List<Properties> getAgentProperties (Long agentId){
                System.out.println("service calling getCategoryProperties ==>");
                Optional<Agent> agent = agentRepository.findById(agentId);
                if (agent.isPresent()) {
                    return agent.get().getPropertiesList();
                } else {
                    throw new InformationNotFoundException("category with id " + agentId + " not found");
                }


            }

//    public Properties getAgentProperties(Long agentId, Long propertiesId) {
//        System.out.println("service calling getAgentProperties ==>");
//        Optional<Agent> agent = agentRepository.findById(agentId);
//        if (agent.isPresent()) {
//            Optional<Properties> properties = Agent.findAgentById(agentId).stream().filter(
//                    p -> p.getId.equals(propertiesId)).findFirst();
//            if (properties.isEmpty()) {
//                throw new InformationNotFoundException("property with id " + propertiesId + " not found");
//            } else {
//                return properties.get();
//            }
//        } else {
//            throw new InformationNotFoundException("agent with id " + agentId + " not found");
//        }
//    }
        }

