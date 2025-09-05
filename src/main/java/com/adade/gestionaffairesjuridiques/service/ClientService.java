package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.common.exception.UsernameAlreadyExistsException;
import com.adade.gestionaffairesjuridiques.domaine.Client;
import com.adade.gestionaffairesjuridiques.dto.ClientDTO;
import com.adade.gestionaffairesjuridiques.ui.forms.CreateCustomerForm;




@Service
@Validated
public interface ClientService {
	
	Optional<ClientDTO> findById(Long id);
	Optional<ClientDTO> findByName(String name);
	List<ClientDTO> findAll();
	void remove(Long id) throws ObjectNotFoundException;
	Client save(ClientDTO c) ;
	Client update(ClientDTO c);

}
