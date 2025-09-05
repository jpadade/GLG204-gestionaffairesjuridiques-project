package com.adade.gestionaffairesjuridiques.dto;

import java.util.Collection;

import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.domaine.Client;
import com.adade.gestionaffairesjuridiques.domaine.Document;
import com.adade.gestionaffairesjuridiques.domaine.Juridiction;
import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class AffaireDTO {

	private Long idAffaire;
	private String nomAffaire;
	private String numeroAffaire;
	private String partieAdverse;
	private String statut;
	private String avocat;
	private String juridication;
	private String client;
	private String typeAffaire;
	private String documents;
	
	public AffaireDTO() {
		// TODO Auto-generated constructor stub
	}

	public AffaireDTO(Long idAffaire, String nomAffaire, String numeroAffaire, String partieAdverse, String statut,
			String avocat, String juridication, String client, String typeAffaire, String documents) {
		super();
		this.idAffaire = idAffaire;
		this.nomAffaire = nomAffaire;
		this.numeroAffaire = numeroAffaire;
		this.partieAdverse = partieAdverse;
		this.statut = statut;
		this.avocat = avocat;
		this.juridication = juridication;
		this.client = client;
		this.typeAffaire = typeAffaire;
		this.documents = documents;
	}

	public Long getIdAffaire() {
		return idAffaire;
	}

	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}

	public String getNomAffaire() {
		return nomAffaire;
	}

	public void setNomAffaire(String nomAffaire) {
		this.nomAffaire = nomAffaire;
	}

	public String getNumeroAffaire() {
		return numeroAffaire;
	}

	public void setNumeroAffaire(String numeroAffaire) {
		this.numeroAffaire = numeroAffaire;
	}

	public String getPartieAdverse() {
		return partieAdverse;
	}

	public void setPartieAdverse(String partieAdverse) {
		this.partieAdverse = partieAdverse;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAvocat() {
		return avocat;
	}

	public void setAvocat(String avocat) {
		this.avocat = avocat;
	}

	public String getJuridication() {
		return juridication;
	}

	public void setJuridication(String juridication) {
		this.juridication = juridication;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getTypeAffaire() {
		return typeAffaire;
	}

	public void setTypeAffaire(String typeAffaire) {
		this.typeAffaire = typeAffaire;
	}

	public String getDocuments() {
		return documents;
	}

	public void setDocuments(String documents) {
		this.documents = documents;
	}

	@Override
	public String toString() {
		return "AffaireDTO [idAffaire=" + idAffaire + ", nomAffaire=" + nomAffaire + ", numeroAffaire=" + numeroAffaire
				+ ", partieAdverse=" + partieAdverse + ", statut=" + statut + ", avocat=" + avocat + ", juridication="
				+ juridication + ", client=" + client + ", typeAffaire=" + typeAffaire + ", documents=" + documents
				+ "]";
	}
	
	

}
