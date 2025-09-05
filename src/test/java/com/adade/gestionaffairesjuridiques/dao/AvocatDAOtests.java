package com.adade.gestionaffairesjuridiques.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adade.gestionaffairesjuridiques.domaine.Avocat;
@SpringBootTest
class AvocatDAOtests {
	@Autowired
	private AvocatDAO avocatDAO;

	@Test
	void testCreateAvocat() {
		Avocat avocat=new Avocat("Akollor","Hervé","akollors@free.fr");
		avocatDAO.save(avocat);
	}

}
