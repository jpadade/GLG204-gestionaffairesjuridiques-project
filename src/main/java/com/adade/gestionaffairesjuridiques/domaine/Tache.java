package com.adade.gestionaffairesjuridiques.domaine;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTache;
	
	private String intitule;
	private String tarifHoraire;
	private Double nbHeures;
	private Double montantTotal;
	private Date dateDebut;
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="idaffaire")
	private Affaire affaire;
	
	@ManyToOne
	@JoinColumn(name="idAvocat")
	private Avocat avocat;

	public Tache() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Tache(String intitule, String tarifHoraire, Double nbHeures, Double montantTotal, Date dateDebut,
			Date dateFin, Affaire affaire, Avocat avocat) {
		super();
		this.intitule = intitule;
		this.tarifHoraire = tarifHoraire;
		this.nbHeures = nbHeures;
		this.montantTotal = montantTotal;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.affaire = affaire;
		this.avocat = avocat;
	}



	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getTarifHoraire() {
		return tarifHoraire;
	}

	public void setTarifHoraire(String tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}

	public Double getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(Double nbHeures) {
		this.nbHeures = nbHeures;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

	public Avocat getAvocat() {
		return avocat;
	}

	public void setAvocat(Avocat avocat) {
		this.avocat = avocat;
	}

	public Long getIdTache() {
		return idTache;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", intitule=" + intitule + ", tarifHoraire=" + tarifHoraire + ", nbHeures="
				+ nbHeures + ", montantTotal=" + montantTotal + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", affaire=" + affaire + ", avocat=" + avocat + "]";
	}
	
	

}
