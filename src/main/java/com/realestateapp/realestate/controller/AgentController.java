package com.realestateapp.realestate.controller;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class AgentController {

    private AgentService agentService;

    @Autowired
    public void setAgentService(AgentService agentService){this.agentService = agentService;}

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/agents/")
            public List<Agent> getAgents(){
        System.out.println("calling getAgents ==>");
        return agentService.getAllAgents();
    }



     @GetMapping("/agents/{agentId}")
    public String getAgents(@PathVariable Long id){
        return "getting agent with id: " + id;
    }

    @PostMapping("/agents/")
    public String createAgent(@RequestBody String body){
        return "creating new agent " + body;
    }

    @PutMapping("/agents/{agentId}")
    public String updateAgent(@PathVariable(value = "agentId") Long agentId, @RequestBody String body) {
        return "updating the agent with the id  " + agentId + body;
    }
    @DeleteMapping("/agents/{agentId}")
    public String deleteAgent(@PathVariable(value = "agentId") Long agentId) {
        return "deleting agent with id of " + agentId;
    }


}
