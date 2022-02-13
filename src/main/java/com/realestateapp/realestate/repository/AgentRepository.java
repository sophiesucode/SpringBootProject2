package com.realestateapp.realestate.repository;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.RealEstateOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findAgentById(Long agentId);

    List<Agent> getAllByRealEstateOffice(RealEstateOffice realEstateOffice);
    Agent findAgentsByName(String name);

}
