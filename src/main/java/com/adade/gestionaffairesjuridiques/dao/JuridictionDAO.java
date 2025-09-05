package com.adade.gestionaffairesjuridiques.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adade.gestionaffairesjuridiques.domaine.Juridiction;

public interface JuridictionDAO extends JpaRepository<Juridiction, Long>{

}
