package com.realestateapp.realestate.service;

import com.realestateapp.realestate.exceptions.InformationExistException;
import com.realestateapp.realestate.exceptions.InformationNotFoundException;
import com.realestateapp.realestate.model.Agent;

import com.realestateapp.realestate.repository.AgentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private AgentRepository agentRepository; //inject repository

    @Autowired //autowire repository to constructor
    public void setAgentRepository(AgentRepository agentRepository){
        this.agentRepository = agentRepository;
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
}

