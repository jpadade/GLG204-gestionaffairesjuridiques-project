package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.TypeAffaireDAO;
import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;
import com.adade.gestionaffairesjuridiques.dto.TypeAffaireDTO;

@Service
@Transactional
@Validated
public class TypeAffaireServiceImpl implements TypeAffaireService {
	@Autowired
	TypeAffaireDAO typeAffaireDAO;
	@Override
	public Optional<TypeAffaireDTO> findById(Long id) {
		
		return typeAffaireDAO.findById(id).map(tache -> DTOMapper.toDTO(tache));
	}

	@Override
	public List<TypeAffaireDTO> findAll() {
		
		return typeAffaireDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (typeAffaireDAO.existsById(id)) {
            typeAffaireDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
	}

	@Override
	public TypeAffaire save(TypeAffaire t) {
		
		return typeAffaireDAO.save(t);
	}

	@Override
	public TypeAffaire update(TypeAffaire t) {
		
		return typeAffaireDAO.save(t);
	}

}
