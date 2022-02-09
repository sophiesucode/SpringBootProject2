package com.realestateapp.realestate.controller;

import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.Properties;
import com.realestateapp.realestate.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional getAgents(@PathVariable Long agentId){
        System.out.println(("calling getAgent ==>"));
        return agentService.getAgent(agentId);
    }



    @PostMapping("/agents/")
    public Agent createAgent(@RequestBody Agent agentObject){
        System.out.println("calling createAgent ==>");
        return agentService.createAgent(agentObject);
    }



    @PutMapping("/agents/{agentId}")
    public Agent updateAgent(@PathVariable(value = "agentId") Long agentId, @RequestBody Agent agentObject) {
        System.out.println("calling updateAgent ==>");
        return agentService.updateAgent(agentId, agentObject);
    }



    @DeleteMapping("/agents/{agentId}")
    public Optional<Agent> deleteAgent(@PathVariable(value = "agentId") Long agentId) {
        System.out.println("calling deleteAgent ==>");
        return agentService.deleteAgent(agentId);
    }

    @PostMapping("/agent/{agentId}/properties/")
    public Properties createAgentProperties(@PathVariable(value = "agentId") Long agentId, @RequestBody Properties propertiesObject) {
        System.out.println("calling createAgentProperties===>");
        return agentService.createAgentProperties(agentId, propertiesObject);
    }

    @GetMapping("/agent/{agentId}/properties/")
    public List<Properties> getAgentProperties(@PathVariable(value = "agentId") Long agentId){
        return agentService.getAgentProperties(agentId);
    }

//    @GetMapping("/agent/{agentId}/properties/{propertiesId}")
//    public Properties getAgentRecipe(
//            @PathVariable(value = "agentId") Long agentId, @PathVariable(value = "propertiesId") Long propertiesId) {
//        System.out.println("calling getAgentProperties ==>");
//        return agentService.getAgentProperties(agentId, propertiesId );
//    }
@GetMapping("/agent/{agentId}/properties/{propertiesId}")
public Properties getPropertiesById(@PathVariable Long agentId, @PathVariable Long propertiesId) {
    System.out.println("calling getPropertiesById");
    return agentService.getPropertiesById(agentId, propertiesId);// or propertyService
}

//@PutMapping("/agent/{agentId}/properties/{propertiesId}")

//
//@DeleteMapping("/agent/{agentId}/properties/{propertiesId}")
//public Properties deleteAgentProperties(@PathVariable Long agentId, @PathVariable Long propertiesId) {
//    System.out.println("calling deleteAgentProperties");
//    return agentService.deleteAgentProperties(agentId, propertiesId);
//}

}
