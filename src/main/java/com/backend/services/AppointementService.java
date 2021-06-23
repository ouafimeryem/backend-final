package com.backend.services;


import com.backend.entities.Agent;
import com.backend.entities.Appointement;
import com.backend.entities.Client;
import com.backend.repositories.AppointementRepository;
import com.backend.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointementService {
	
    @Autowired
    AppointementRepository appointementRepository;
    
    @Autowired
    ClientRepository clientRepository;
    
    @Autowired
    ClientService clientService;
    
    @Autowired
    AgentService agentService;

    public List<Appointement> findAllForClient() {
    	Client client = clientService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    	
    	List<Appointement> app = client.getAppointements();
    	
        return app;
    }
    
    public List<Appointement> findAllForAgent() {
    	Agent agent = agentService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    	
    	List<Appointement> app = agent.getAppointements();
    	
        return app;
    }
    
    public void addRendezVous(Appointement s) {
    	Client client = clientService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

            if (s.getDate1()!=s.getDate2() && !s.getDate1().equals(LocalDateTime.now()) && s.getDate2().after(s.getDate1())) {
                
            	s.setDt(LocalDateTime.now());
                client.getAppointements().add(s);
                appointementRepository.save(s);
           }
    }
    
    public void deleteById(Long aLong) {
        appointementRepository.deleteById(aLong);
    }
    
    public void confirmRendezVous(Appointement s){
        s.setConfirmed(true);
        appointementRepository.save(s);
    }

    public Optional<Appointement> findById(Long id) {
        return appointementRepository.findById(id);
    }

}
