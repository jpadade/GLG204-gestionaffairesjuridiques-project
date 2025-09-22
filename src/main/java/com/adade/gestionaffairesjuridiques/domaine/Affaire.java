package com.adade.gestionaffairesjuridiques.domaine;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Affaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;
	private String nomAffaire;
	private String numeroAffaire;
	private String partieAdverse;
	private String statut;
	@ManyToOne
	@JoinColumn(name="idAvocat")
	private Avocat avocat;
	
	@ManyToOne
	@JoinColumn(name="idJuridiction")
	private Juridiction juridiction;
	
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="idTypeAffaire")
	private TypeAffaire typeAffaire;
	
	@ManyToMany
	@JoinTable(name = "Affaire_Document",
	joinColumns = @JoinColumn(name = "IdAffaire"),
	inverseJoinColumns = @JoinColumn(name = "IdDocument"))
	private Collection <Document> documents;
	

	public Affaire() {
		// TODO Auto-generated constructor stub
	}


	public Affaire(Long idAffaire, String nomAffaire, String numeroAffaire, String partieAdverse, String statut,
			Avocat avocat, Juridiction juridiction, Client client, TypeAffaire typeAffaire,
			Collection<Document> documents) {
		super();
		this.idAffaire = idAffaire;
		this.nomAffaire = nomAffaire;
		this.numeroAffaire = numeroAffaire;
		this.partieAdverse = partieAdverse;
		this.statut = statut;
		this.avocat = avocat;
		this.juridiction = juridiction;
		this.client = client;
		this.typeAffaire = typeAffaire;
		this.documents = documents;
	}


	public Affaire(String nomAffaire, String numeroAffaire, String partieAdverse, String statut, Avocat avocat,
			Juridiction juridiction, Client client, TypeAffaire typeAffaire, Collection<Document> documents) {
		super();
		this.nomAffaire = nomAffaire;
		this.numeroAffaire = numeroAffaire;
		this.partieAdverse = partieAdverse;
		this.statut = statut;
		this.avocat = avocat;
		this.juridiction = juridiction;
		this.client = client;
		this.typeAffaire = typeAffaire;
		this.documents = documents;
	}


	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}
	
	public Long getIdAffaire() {
		return idAffaire;
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





	@Override
	public String toString() {
		return "Affaire [idAffaire=" + idAffaire + ", nomAffaire=" + nomAffaire + ", numeroAffaire=" + numeroAffaire
				+ ", partieAdverse=" + partieAdverse + ", statut=" + statut + ", avocat=" + avocat + ", juridication="
				+ juridiction + ", client=" + client + ", typeAffaire=" + typeAffaire + ", documents=" + documents
				+ "]";
	}








}
