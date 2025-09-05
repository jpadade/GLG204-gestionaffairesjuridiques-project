package com.adade.gestionaffairesjuridiques.dto;

import java.util.Date;

public class TacheDTO {
	private Long idTache;
	private String intitule;
	private String tarifHoraire;
	private Double nbHeures;
	private Double montantTotal;
	private Date dateDebut;
	private Date dateFin;
	private String affaire;
	private String avocat;
	
	public TacheDTO() {
		// TODO Auto-generated constructor stub
	}

	public TacheDTO(Long idTache, String intitule, String tarifHoraire, Double nbHeures, Double montantTotal,
			Date dateDebut, Date dateFin,String affaire,String avocat) {
		super();
		this.idTache = idTache;
		this.intitule = intitule;
		this.tarifHoraire = tarifHoraire;
		this.nbHeures = nbHeures;
		this.montantTotal = montantTotal;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Long getIdTache() {
		return idTache;
	}

	public void setIdTache(Long idTache) {
		this.idTache = idTache;
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
	
	

	public String getAffaire() {
		return affaire;
	}

	public void setAffaire(String affaire) {
		this.affaire = affaire;
	}

	public String getAvocat() {
		return avocat;
	}

	public void setAvocat(String avocat) {
		this.avocat = avocat;
	}

	@Override
	public String toString() {
		return "TacheDTO [idTache=" + idTache + ", intitule=" + intitule + ", tarifHoraire=" + tarifHoraire
				+ ", nbHeures=" + nbHeures + ", montantTotal=" + montantTotal + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", affaire=" + affaire + ", avocat=" + avocat + "]";
	}



}
