package com.adade.gestionaffairesjuridiques.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;

public interface TypeAffaireDAO extends JpaRepository<TypeAffaire, Long> {

}
