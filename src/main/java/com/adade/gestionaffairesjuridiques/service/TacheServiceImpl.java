package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.TacheDAO;
import com.adade.gestionaffairesjuridiques.domaine.Tache;
import com.adade.gestionaffairesjuridiques.dto.TacheDTO;

@Service
@Transactional
@Validated
public class TacheServiceImpl implements TacheService {

	@Autowired
	TacheDAO tacheDAO;
	@Override
	public Optional<TacheDTO> findById(Long id) {
		
		return tacheDAO.findById(id).map(tache -> DTOMapper.toDTO(tache));
	}

	@Override
	public List<TacheDTO> findAll() {
		// TODO Auto-generated method stub
		return tacheDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (tacheDAO.existsById(id)) {
            tacheDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
        
		
	}

	@Override
	public Tache save(Tache t) {
		// TODO Auto-generated method stub
		return tacheDAO.save(t);
	}

	@Override
	public Tache update(Tache t) {
		// TODO Auto-generated method stub
		return tacheDAO.save(t);
	}

}
