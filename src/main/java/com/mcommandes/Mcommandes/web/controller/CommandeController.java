package com.mcommandes.Mcommandes.web.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcommandes.Mcommandes.configurations.ApplicationPropertiesConfiguration;
import com.mcommandes.Mcommandes.dao.CommandeDao;
import com.mcommandes.Mcommandes.model.Commande;

@RestController
public class CommandeController implements HealthIndicator {
	
	@Autowired
	CommandeDao commandeDao;
	
	@Autowired
	ApplicationPropertiesConfiguration appProperties;
	
	@GetMapping("/Commandes")
	public List<Commande> listeDesCommandes(){
		List<Commande> commandes = commandeDao.findAll();
		List<Commande> listeLimitee = commandes.subList(0, appProperties.getLimitDeCommandes());
		return listeLimitee;
	}
	
	@GetMapping("/Commandes/{id}")
	public Optional<Commande> recupererUneCommande(@PathVariable Integer id){
		Optional<Commande> commande = commandeDao.findById(id);
		return commande;
	}
	
	@PostMapping("/Commandes")
	public Commande saveCommande(@RequestBody Commande commande) {
		return commandeDao.save(commande);
	}
	
	@DeleteMapping("/Commandes")
	public String deleteCommande(Integer id) {
		Commande commande = commandeDao.findById(id).get();
		commandeDao.delete(commande);
		return "Successfully deleted";
	}
	

	@Override
	public Health health() {
		System.out.println("****** Actuator : CommandeController health() ");
		List<Commande> commandes = commandeDao.findAll();
		if(commandes.isEmpty()) {
			return Health.down().build();
		}
		return Health.up().build();
	}
	
	
	
	

}
