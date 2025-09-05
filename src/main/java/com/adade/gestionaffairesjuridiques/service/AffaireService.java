package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Affaire;
import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.dto.AffaireDTO;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;

@Service
@Validated
public interface AffaireService {
	
	Optional<AffaireDTO> findById(Long id);
	Optional<AffaireDTO> findByNumber(String numeroAffaire);
	List<AffaireDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Affaire save(Affaire a) ;
	Affaire update(Affaire a);

}
