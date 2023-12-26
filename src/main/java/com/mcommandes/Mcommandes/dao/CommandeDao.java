package com.mcommandes.Mcommandes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcommandes.Mcommandes.model.Commande;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer>  {

}
