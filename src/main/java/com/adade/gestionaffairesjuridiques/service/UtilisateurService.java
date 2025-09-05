package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.domaine.Utilisateur;
import com.adade.gestionaffairesjuridiques.dto.UtilisateurDTO;

@Service
@Validated
public interface UtilisateurService {
	
	Optional<UtilisateurDTO> findById(Long id);
	Optional<UtilisateurDTO> findByLogin(String login);
	List<UtilisateurDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Utilisateur save(Utilisateur u) ;
	Utilisateur update(Utilisateur u);

}
