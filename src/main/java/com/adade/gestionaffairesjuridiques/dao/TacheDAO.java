package com.adade.gestionaffairesjuridiques.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adade.gestionaffairesjuridiques.domaine.Tache;

public interface TacheDAO extends JpaRepository<Tache, Long>{

}
