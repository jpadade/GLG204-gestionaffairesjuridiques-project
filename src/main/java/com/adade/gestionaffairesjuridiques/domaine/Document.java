package com.adade.gestionaffairesjuridiques.domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	private String nomDocument;
	private String description;
	private String typeDocument;
	private String lienFichier;
	private String statut;
	

	public Document() {
		// TODO Auto-generated constructor stub
	}


	public Document( String nomDocument, String description, String typeDocument, String lienFichier,
			String statut) {
		super();
		this.nomDocument = nomDocument;
		this.description = description;
		this.typeDocument = typeDocument;
		this.lienFichier = lienFichier;
		this.statut = statut;
	}


	public String getNomDocument() {
		return nomDocument;
	}


	public void setNomDocument(String nomDocument) {
		this.nomDocument = nomDocument;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getTypeDocument() {
		return typeDocument;
	}


	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}


	public String getLienFichier() {
		return lienFichier;
	}


	public void setLienFichier(String lienFichier) {
		this.lienFichier = lienFichier;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public Long getIdDocument() {
		return idDocument;
	}


	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", nomDocument=" + nomDocument + ", description=" + description
				+ ", typeDocument=" + typeDocument + ", lienFichier=" + lienFichier + ", statut=" + statut + "]";
	}





}
