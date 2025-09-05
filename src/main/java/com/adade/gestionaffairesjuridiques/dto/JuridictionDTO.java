package com.adade.gestionaffairesjuridiques.dto;

public class JuridictionDTO {

	private Long idJuridiction;
	private String nom;
	private String telephone;
	private String fax;
	private String email;
	private String adresse;
	private String adresseComplement;
	private String ville;
	private String codePostal;
	
	public JuridictionDTO() {
		// TODO Auto-generated constructor stub
	}

	public JuridictionDTO(Long idJuridiction, String nom, String telephone, String fax, String email, String adresse,
			String adresseComplement, String ville, String codePostal) {
		super();
		this.idJuridiction = idJuridiction;
		this.nom = nom;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.adresse = adresse;
		this.adresseComplement = adresseComplement;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Long getIdJuridiction() {
		return idJuridiction;
	}

	public void setIdJuridiction(Long idJuridiction) {
		this.idJuridiction = idJuridiction;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getAdresseComplement() {
		return adresseComplement;
	}

	public void setAdresseComplement(String adresseComplement) {
		this.adresseComplement = adresseComplement;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "JuridictionDTO [idJuridiction=" + idJuridiction + ", nom=" + nom + ", telephone=" + telephone + ", fax="
				+ fax + ", email=" + email + ", adresse=" + adresse + ", adresseComplement=" + adresseComplement
				+ ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}

}
