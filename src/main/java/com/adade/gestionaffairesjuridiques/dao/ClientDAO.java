package com.adade.gestionaffairesjuridiques.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adade.gestionaffairesjuridiques.domaine.Client;


public interface ClientDAO extends JpaRepository<Client, Long> {
	
    @Query("select c from Client c where c.nom = :name and c.prenom = :firstname")
    Optional<Client> findByNameAndFirstname(@Param("name") String name,@Param("firstname") String fistname );
}
