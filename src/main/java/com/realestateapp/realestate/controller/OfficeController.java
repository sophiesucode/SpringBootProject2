package com.realestateapp.realestate.controller;


import com.realestateapp.realestate.model.Agent;
import com.realestateapp.realestate.model.RealEstateOffice;

import com.realestateapp.realestate.service.AgentService;
import com.realestateapp.realestate.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//company can add more offices/branches under company if they choose to open more in future/present
/*what if I want to get a list a properties without it being associated with a specific office id? I want all offices to work
with same database of properties */
//get list of all properties in general
// I want to get a list of all properties owned by company in general,

//office will get agents by office id and can get agents by  agent id and office id
@RestController
@RequestMapping(path = "/api")
public class OfficeController {


    private OfficeService officeService;


    @Autowired
    public void setOfficeService(OfficeService officeService) {
        this.officeService = officeService;
    }

    public OfficeService getOfficeService() {
        return officeService;
    }


    //    private AgentService agentService;
//    public AgentService getAgentService() {
//        return agentService;
//    }
//
    @GetMapping(path = "/office/")
    public List<RealEstateOffice> getOffice() {
        System.out.println("calling getOffices ==>");
        return officeService.getAllOffices();
    }

    @GetMapping("/office/{officeId}")
    public Optional getOffice(@PathVariable Long officeId) {
        System.out.println(("calling getOffice ==>"));
        return officeService.getOffice(officeId);
    }

    @PostMapping("/office/")
    public RealEstateOffice createOffice(@RequestBody RealEstateOffice realEstateOfficeObject) {
        System.out.println("calling createOffice ==> ");
        return officeService.createOffice(realEstateOfficeObject);

    }

     @PutMapping("/office/{officeId}")
    public RealEstateOffice updateOffice(@PathVariable(value = "officeId") Long officeId, @RequestBody RealEstateOffice realEstateOfficeOject) {
        System.out.println("calling updateOffice ==>");
        return officeService.updateOffice(officeId, realEstateOfficeOject);
    }

     @DeleteMapping("/office/{officeId}")
        public Optional<RealEstateOffice> deleteOffice(@PathVariable(value = "officeId") Long officeId) {
            System.out.println("calling deleteOffice ==>");
            return officeService.deleteOffice(officeId);
        }
}






















































































































































































































    //    @GetMapping(path = "/office/{officeId}/agents/")
//    public List<Agent> getAgentsByRealEstateOffice(){
//    System.out.println("getAgentsByRealEstateOffice");
//    return agentService.findAgentsByOffice(Long officeId);
//
//    //path paeremter find agent by office

//}




// get all properties more important .....already joined
//get all clients ....join office to client
//get all agents--- most important....join agents to office