package com.adade.gestionaffairesjuridiques.ui.forms;

import java.util.Collection;

import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.domaine.Client;
import com.adade.gestionaffairesjuridiques.domaine.Document;
import com.adade.gestionaffairesjuridiques.domaine.Juridiction;
import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;
import com.adade.gestionaffairesjuridiques.dto.AffaireDTO;

public class CreateAffaireForm {
	
	private Long idAffaire;
	private String nomAffaire;
	private String numeroAffaire;
	private String partieAdverse;
	private String statut;
	private Avocat avocat;
	private Juridiction juridiction;
	private Client client;
	private TypeAffaire typeAffaire;
	private Collection<Document> documents;
	
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
	public Avocat getAvocat() {
		return avocat;
	}
	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}
	public Juridiction getJuridiction() {
		return juridiction;
	}
	public void setJuridiction(Juridiction juridiction) {
		this.juridiction = juridiction;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public TypeAffaire getTypeAffaire() {
		return typeAffaire;
	}
	public void setTypeAffaire(TypeAffaire typeAffaire) {
		this.typeAffaire = typeAffaire;
	}
	public Collection<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Collection<Document> documents) {
		this.documents = documents;
	}
	
	public AffaireDTO toDTO() {
		
		AffaireDTO dto = new AffaireDTO();
		dto.setNomAffaire(nomAffaire);
		dto.setNumeroAffaire(numeroAffaire);
		dto.setPartieAdverse(partieAdverse);
		dto.setStatut(statut);
		dto.setAvocat(avocat);
		dto.setJuridiction(juridiction);
		dto.setClient(client);
		dto.setTypeAffaire(typeAffaire);
		dto.setDocuments(documents);
		return dto;
	}

	
	

}
