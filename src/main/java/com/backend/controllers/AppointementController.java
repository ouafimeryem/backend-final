package com.backend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.backend.entities.Appointement;
import com.backend.services.AppointementService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AppointementController {
    @Autowired
    private AppointementService appointementService;


    //Get
    @GetMapping("/RendezVous")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointement> findAllForClient() {
        return appointementService.findAllForClient();
    }
    
    @GetMapping("/AgentRv")
    @ResponseStatus(HttpStatus.OK)
    public List<Appointement> findAllForAgent() {
        return appointementService.findAllForAgent();
    }
    
    @GetMapping("/RendesVous/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Appointement> findById(@PathVariable Long id) {
        return appointementService.findById(id);
    }


    //Post
    @PostMapping("/RendezVous")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRendezVous(@RequestBody Appointement s) {
        appointementService.addRendezVous(s);
    }

    //put
    @PutMapping("/AgentRv")
    @ResponseStatus(HttpStatus.OK)
    public void confirmRendezVous(@RequestBody Appointement s) {
        appointementService.confirmRendezVous(s);
    }

    //Delete
    @DeleteMapping("/RendezVous/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        appointementService.deleteById(id);
    }

}
