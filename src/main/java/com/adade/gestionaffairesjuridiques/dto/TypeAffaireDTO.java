package com.adade.gestionaffairesjuridiques.dto;

public class TypeAffaireDTO {

	private Long idTypeAffaire;
	private String libelle;
	
	public TypeAffaireDTO() {
		// TODO Auto-generated constructor stub
	}

	public TypeAffaireDTO(Long idTypeAffaire, String libelle) {
		super();
		this.idTypeAffaire = idTypeAffaire;
		this.libelle = libelle;
	}

	public Long getIdTypeAffaire() {
		return idTypeAffaire;
	}

	public void setIdTypeAffaire(Long idTypeAffaire) {
		this.idTypeAffaire = idTypeAffaire;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "TypeAffaireDTO [idTypeAffaire=" + idTypeAffaire + ", libelle=" + libelle + "]";
	}

}
