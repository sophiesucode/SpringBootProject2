package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository <Agent , Long> {

//     Agent findById(agentId);
//     Agent findAgentsById( Long agentId) ;

Agent findAgentsByName(String name);


}
