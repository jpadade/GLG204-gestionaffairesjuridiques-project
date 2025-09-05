package com.adade.gestionaffairesjuridiques.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adade.gestionaffairesjuridiques.domaine.Avocat;

public interface AvocatDAO extends JpaRepository<Avocat, Long> {
	
    @Query("select a from Avocat a where a.nom = :name")
    Optional<Avocat> findByName(@Param("name") String name);

}
