package com.mcommandes.Mcommandes.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Commande {
	@Id
	@GeneratedValue
     private Integer id;
     private String description;
     private Integer quantite;
     private Date date;
     private double montant;
     
	public Commande() {
		
	}

	public Commande(Integer id, String description, Integer quantite, Date date, double montant) {
		super();
		this.id = id;
		this.description = description;
		this.quantite = quantite;
		this.date = date;
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", description=" + description + ", quantite=" + quantite + ", date=" + date
				+ ", montant=" + montant + "]";
	}
	
	
	
     
     
}
