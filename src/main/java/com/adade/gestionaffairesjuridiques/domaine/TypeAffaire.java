package com.adade.gestionaffairesjuridiques.domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeAffaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeAffaire;
	private String libelle;
	
	public TypeAffaire() {
		// TODO Auto-generated constructor stub
	}
	

	public TypeAffaire(String libelle) {
		super();
		this.libelle = libelle;
	}


	public Long getIdTypeAffaire() {
		return idTypeAffaire;
	}
/*
	public void setIdTypeAffaire(Long idTypeAffaire) {
		this.idTypeAffaire = idTypeAffaire;
	}
*/
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return "TypeAffaire [idTypeAffaire=" + idTypeAffaire + ", libelle=" + libelle + "]";
	}
	
	

}
