package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Tache;
import com.adade.gestionaffairesjuridiques.dto.TacheDTO;

@Service
@Validated
public interface TacheService {

	Optional<TacheDTO> findById(Long id);
	List<TacheDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Tache save(Tache t) ;
	Tache update(Tache t);
}
