package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.AffaireDAO;
import com.adade.gestionaffairesjuridiques.domaine.Affaire;
import com.adade.gestionaffairesjuridiques.dto.AffaireDTO;

@Service
@Transactional
@Validated
public class AffaireServiceImpl implements AffaireService {
	@Autowired
	AffaireDAO affaireDAO;
	@Override
	public Optional<AffaireDTO> findById(Long id) {
		
		return affaireDAO.findById(id).map(affaire -> DTOMapper.toDTO(affaire));
	}

	@Override
	public Optional<AffaireDTO> findByNumber(String numeroAffaire) {
		
		return affaireDAO.findByNumber(numeroAffaire).map(affaire -> DTOMapper.toDTO(affaire));
	}

	@Override
	public List<AffaireDTO> findAll() {
		
		return affaireDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
	      if (affaireDAO.existsById(id)) {
	            affaireDAO.deleteById(id);
	        } else {
	            throw new ObjectNotFoundException();
	        }
			
		
	}

	@Override
	public Affaire save(Affaire a) {
		
		return affaireDAO.save(a);
	}

	@Override
	public Affaire update(Affaire a) {
		
		return affaireDAO.save(a);
	}

}
