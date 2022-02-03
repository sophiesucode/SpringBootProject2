package com.realestateapp.realestate.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class AgentController {

    @GetMapping(path = "/hello-world/")
    public String getHelloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/agents/")
            public String getAgents() {
            return "get all agents";
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
