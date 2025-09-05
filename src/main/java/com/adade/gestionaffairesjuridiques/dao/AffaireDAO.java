package com.adade.gestionaffairesjuridiques.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adade.gestionaffairesjuridiques.domaine.Affaire;


public interface AffaireDAO extends JpaRepository<Affaire, Long>{

    @Query("select a from Affaire a where a.numeroAffaire = :number")
    Optional<Affaire> findByNumber(@Param("number") String number);	
	
}


