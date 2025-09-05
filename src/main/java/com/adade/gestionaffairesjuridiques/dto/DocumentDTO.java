package com.adade.gestionaffairesjuridiques.dto;

public class DocumentDTO {
	private Long idDocument;
	private String nomDocument;
	private String description;
	private String typeDocument;
	private String lienFichier;
	private String statut;
	public DocumentDTO() {
		// TODO Auto-generated constructor stub
	}
	public DocumentDTO(Long idDocument, String nomDocument, String description, String typeDocument, String lienFichier,
			String statut) {
		super();
		this.idDocument = idDocument;
		this.nomDocument = nomDocument;
		this.description = description;
		this.typeDocument = typeDocument;
		this.lienFichier = lienFichier;
		this.statut = statut;
	}
	public Long getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
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
	@Override
	public String toString() {
		return "DocumentDTO [idDocument=" + idDocument + ", nomDocument=" + nomDocument + ", description=" + description
				+ ", typeDocument=" + typeDocument + ", lienFichier=" + lienFichier + ", statut=" + statut + "]";
	}

}
