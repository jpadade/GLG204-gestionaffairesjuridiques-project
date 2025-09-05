package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.AvocatDAO;
import com.adade.gestionaffairesjuridiques.dao.ClientDAO;
import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;

@Service
@Transactional
@Validated
public class AvocatServiceImpl implements AvocatService {

	@Autowired
	AvocatDAO avocatDAO;
	
    @Autowired
    DTOMapper myDTOMapper;
    
	@Override
	public Optional<AvocatDTO> findById(Long id) {
		
		return avocatDAO.findById(id).map(avocat -> DTOMapper.toDTO(avocat));
	}

	@Override
	public Optional<AvocatDTO> findByName(String name) {
		
		return avocatDAO.findByName(name).map(avocat -> DTOMapper.toDTO(avocat));
	}

	@Override
	public List<AvocatDTO> findAll() {
		
		return avocatDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (avocatDAO.existsById(id)) {
            avocatDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
		
	}

	@Override
	public Avocat save(AvocatDTO a) {
		Avocat avocat = new Avocat();
		myDTOMapper.fillAvocatFromDTO(avocat, a);
		return avocatDAO.save(avocat);
	}

	@Override
	public Avocat update(AvocatDTO a) {
		Avocat avocat = new Avocat(a.getIdAvocat(),a.getNom(),a.getPrenom(), a.getEmail(), a.getTelephoneFixe(),
				a.getTelephoneMobile(), a.getAdresse(), a.getAdresseComplement(),a.getVille(),a.getCodePostal());
		myDTOMapper.fillAvocatUpdateFromDTO(avocat, a);		
		return avocatDAO.save(avocat);
	}

}
