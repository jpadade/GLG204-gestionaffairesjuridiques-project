package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Juridiction;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;

@Service
@Validated
public interface JuridictionService {

	Optional<JuridictionDTO> findById(Long id);
	List<JuridictionDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Juridiction save(JuridictionDTO j) ;
	Juridiction update(JuridictionDTO j);
	
}
