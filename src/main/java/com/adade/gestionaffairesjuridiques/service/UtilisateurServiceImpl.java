package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.UtilisateurDAO;
import com.adade.gestionaffairesjuridiques.domaine.Utilisateur;
import com.adade.gestionaffairesjuridiques.dto.UtilisateurDTO;

@Service
@Transactional
@Validated
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	UtilisateurDAO utilisateurDAO;
	@Override
	public Optional<UtilisateurDTO> findById(Long id) {
		
		return utilisateurDAO.findById(id).map(utilisateur -> DTOMapper.toDTO(utilisateur));
	}

	@Override
	public Optional<UtilisateurDTO> findByLogin(String login) {
		
		return utilisateurDAO.findByLogin(login).map(utilisateur -> DTOMapper.toDTO(utilisateur));
	}

	@Override
	public List<UtilisateurDTO> findAll() {
		
		return utilisateurDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (utilisateurDAO.existsById(id)) {
            utilisateurDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
		
		
	}

	@Override
	public Utilisateur save(Utilisateur u) {
		
		return utilisateurDAO.save(u);
	}

	@Override
	public Utilisateur update(Utilisateur u) {
		
		return utilisateurDAO.save(u);
	}

}
