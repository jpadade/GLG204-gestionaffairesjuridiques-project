package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Document;
import com.adade.gestionaffairesjuridiques.dto.DocumentDTO;


@Service
@Validated
public interface DocumentService {
	
	Optional<DocumentDTO> findById(Long id);
	List<DocumentDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Document save(Document d) ;
	Document update(Document d);

}
