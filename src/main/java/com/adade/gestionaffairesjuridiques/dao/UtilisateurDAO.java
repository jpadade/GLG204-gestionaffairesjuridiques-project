package com.adade.gestionaffairesjuridiques.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adade.gestionaffairesjuridiques.domaine.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long>{

    @Query("select u from Utilisateur u where u.login = :login")
    Optional<Utilisateur> findByLogin(@Param("login") String login);	
	
}


