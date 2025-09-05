package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.AvocatDAO;
import com.adade.gestionaffairesjuridiques.dao.JuridictionDAO;
import com.adade.gestionaffairesjuridiques.domaine.Juridiction;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;

@Service
@Transactional
@Validated
public class JuridictionServiceImpl implements JuridictionService {

	@Autowired
	JuridictionDAO juridictionDAO;
	
    @Autowired
    DTOMapper myDTOMapper;
	
	
	@Override
	public Optional<JuridictionDTO> findById(Long id) {
		
		return juridictionDAO.findById(id).map(juridiction -> DTOMapper.toDTO(juridiction));
	}

	@Override
	public List<JuridictionDTO> findAll() {
		
		return juridictionDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (juridictionDAO.existsById(id)) {
            juridictionDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
		
	}

	@Override
	public Juridiction save(JuridictionDTO j) {
		 Juridiction juridication = new Juridiction();
		 myDTOMapper.fillJuridictionFromDTO(juridication, j);
		return juridictionDAO.save(juridication);
	}

	@Override
	public Juridiction update(JuridictionDTO j) {
		Juridiction juridiction = new Juridiction(j.getIdJuridiction(), j.getNom(), j.getTelephone(),
				j.getFax(),j.getEmail(), j.getAdresse(), j.getAdresseComplement(), j.getVille(),j.getCodePostal());
		myDTOMapper.fillJuridictionUpdateFromDTO(juridiction, j);
		return juridictionDAO.save(juridiction);
	}

}
