package com.adade.gestionaffairesjuridiques.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adade.gestionaffairesjuridiques.domaine.Client;

@SpringBootTest
class ClientDAOtests {
	@Autowired
	private ClientDAO clientDAO;
	
	@Test
	public void testCreateClient() {
		Client client= new Client("Mr","ADADE", "Jean-philippe","0631360831", "jean-philippe.adade@hotmail.fr");
		clientDAO.save(client);
	}
	
	@Test
	public void testFindClient()
	{ 
		Client c= clientDAO.findById(2L).get();System.out.println(c);
		
	}
	@Test
	public void testUpdateClient()
	{ 
	  Client c= clientDAO.findById(2L).get();
	  c.setAdresse("7 rue des bergères");
	  c.setVille("Les Ulis");
	  c.setCodePostal("91940");
	  clientDAO.save(c);
	
	}
	
	@Test
	public void testDeleteClient()
	{ clientDAO.deleteById(3L);;
	}
	
	@Test
	public void testListerLesClients()
	{
	List<Client> clients = clientDAO.findAll();
	for (Client c : clients)
	{
	System.out.println(c);
	}
	}

}
