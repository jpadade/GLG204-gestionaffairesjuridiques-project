package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;
import com.adade.gestionaffairesjuridiques.dto.TypeAffaireDTO;

@Service
@Validated
public interface TypeAffaireService {
	
	Optional<TypeAffaireDTO> findById(Long id);
	List<TypeAffaireDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	TypeAffaire save(TypeAffaire t) ;
	TypeAffaire update(TypeAffaire t);

}
