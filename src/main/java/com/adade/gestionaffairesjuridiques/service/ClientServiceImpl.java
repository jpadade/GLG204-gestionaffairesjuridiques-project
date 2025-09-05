package com.adade.gestionaffairesjuridiques.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.adade.gestionaffairesjuridiques.common.exception.ObjectNotFoundException;
import com.adade.gestionaffairesjuridiques.dao.ClientDAO;
import com.adade.gestionaffairesjuridiques.domaine.Client;
import com.adade.gestionaffairesjuridiques.dto.ClientDTO;



@Service
@Transactional
@Validated
public class ClientServiceImpl   implements ClientService{

    @Autowired
    ClientDAO clientDAO;
    
    @Autowired
    DTOMapper myDTOMapper;
   
    
    
	@Override
	public Optional<ClientDTO> findById(Long id) {
		
		return clientDAO.findById(id).map(client -> DTOMapper.toDTO(client));
	}

	@Override
	public Optional<ClientDTO> findByName(String name) {
		
		return clientDAO.findByName(name).map(client -> DTOMapper.toDTO(client));
	}

	@Override
	public List<ClientDTO> findAll() {
		
		return clientDAO.findAll().stream().map(DTOMapper::toDTO).toList();
	}

	@Override
	public void remove(Long id) throws ObjectNotFoundException {
        if (clientDAO.existsById(id)) {
            clientDAO.deleteById(id);
        } else {
            throw new ObjectNotFoundException();
        }
		
	}

	@Override
	public Client save(ClientDTO c)
	{     Client MyClient = new Client();

		 myDTOMapper.fillClientFromDTO(MyClient, c);
		
			return clientDAO.save(MyClient);
		
		
		
	}

	@Override
	public Client update(ClientDTO c) {
			
	Client myClient=new Client(c.getIdClient(),c.getCivilite(),c.getNom(), c.getPrenom(), c.getDateDeNaissance(), c.getDepartementDeNaissance(), c.getPaysDeNaissance(),c.getNationalite(), c.getTelephoneFixe(), c.getTelephoneMobile(), c.getEmail(), c.getAdresse(), c.getAdresseComplement(), c.getVille(),c.getCodePostal());
		
		//Client myClient=clientDAO.findById(c.getIdClient()).get();
	 //Client myClient=clientDAO.getReferenceById(c.getIdClient());
		myDTOMapper.fillClientUpdateFromDTO(myClient, c);
		
		
		return clientDAO.save(myClient);
	}


}
