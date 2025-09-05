package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;


@Service
@Validated
public interface AvocatService {

	Optional<AvocatDTO> findById(Long id);
	Optional<AvocatDTO> findByName(String name);
	List<AvocatDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Avocat save(AvocatDTO a) ;
	Avocat update(AvocatDTO a);
	
}
