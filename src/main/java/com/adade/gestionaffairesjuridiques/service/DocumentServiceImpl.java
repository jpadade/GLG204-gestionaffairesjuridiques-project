package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.DocumentDAO;
import com.adade.gestionaffairesjuridiques.domaine.Document;
import com.adade.gestionaffairesjuridiques.dto.DocumentDTO;

@Service
@Transactional
@Validated
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	DocumentDAO documentDAO;
	
	@Override
	public Optional<DocumentDTO> findById(Long id) {
		
		return documentDAO.findById(id).map(document -> DTOMapper.toDTO(document));
	}

	@Override
	public List<DocumentDTO> findAll() {
		
		return documentDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (documentDAO.existsById(id)) {
            documentDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
	}

	@Override
	public Document save(Document d) {
		// TODO Auto-generated method stub
		return documentDAO.save(d);
	}

	@Override
	public Document update(Document d) {
		// TODO Auto-generated method stub
		return documentDAO.save(d);
	}

}
