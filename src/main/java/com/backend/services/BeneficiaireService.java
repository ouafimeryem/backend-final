package com.backend.services;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.backend.entities.Agent;
import com.backend.entities.Beneficiaire;
import com.backend.entities.Client;
import com.backend.entities.Compte;
import com.backend.exceptions.AlreadyExistsException;
import com.backend.exceptions.NotFoundException;
import com.backend.repositories.BeneficiaireRepository;
import com.backend.repositories.CompteRepository;
import com.itextpdf.text.DocumentException;

@Service
public class BeneficiaireService {
	
	@Autowired
	BeneficiaireRepository rep;
	
	@Autowired
	CompteRepository repCompte;
	
	Logger logger = LoggerFactory.getLogger(BeneficiaireService.class.getName());
	
	public List<Beneficiaire> getBeneficiaires(Long id) throws NotFoundException
	{

		List<Beneficiaire> beneficiaires= new ArrayList<Beneficiaire>();	

		if(id!=null)
			beneficiaires.add(rep.findById(id).orElseThrow(() -> new NotFoundException("Aucun compte avec l'id "+id+" trouvé")));

		else
			beneficiaires=rep.findAll();

		if(beneficiaires.isEmpty())  throw new NotFoundException("Aucun compte trouvé");
		
		return beneficiaires;
	}
	
	public void addBeneficiaire(Beneficiaire beneficiaire) throws AlreadyExistsException, DocumentException, FileNotFoundException
	{
		if(rep.findByNumero(beneficiaire.getNumero()).isPresent()) {
			throw new AlreadyExistsException("Un compte avec le Numero "+beneficiaire.getNumero()+" existe déjà");
		}
		
		if(!repCompte.findByNumero(beneficiaire.getNumero()).isPresent()){
			throw new NotFoundException("compte non trouvé");
		}

		rep.save(beneficiaire);

	}
	
	public void removeBeneficiaire(Long id) throws NotFoundException
	{
		//vérifier l'existence
		Beneficiaire beneficiaire=rep.findById(id).orElseThrow(() -> new NotFoundException("Aucun compte avec l'id "+id+" n'est trouvé"));
		rep.delete(beneficiaire);
	}
}
