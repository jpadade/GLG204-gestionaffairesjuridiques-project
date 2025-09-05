package com.adade.gestionaffairesjuridiques.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adade.gestionaffairesjuridiques.domaine.Document;

public interface DocumentDAO extends JpaRepository<Document, Long>{

}
