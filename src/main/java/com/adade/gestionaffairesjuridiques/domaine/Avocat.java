package com.adade.gestionaffairesjuridiques.domaine;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Avocat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvocat;
	private String nom; 
	private String prenom;
	private String telephoneFixe;
	private String telephoneMobile;
	private String email;
	private String adresse;
	private String adresseComplement;
	private String ville;
	private String codePostal;

	public Avocat() {
		// TODO Auto-generated constructor stub
	}

	public Avocat(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Avocat(Long idAvocat, String nom, String prenom, String telephoneFixe, String telephoneMobile, String email,
			String adresse, String adresseComplement, String ville, String codePostal) {
		super();
		this.idAvocat = idAvocat;
		this.nom = nom;
		this.prenom = prenom;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.email = email;
		this.adresse = adresse;
		this.adresseComplement = adresseComplement;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Long getIdAvocat() {
		return idAvocat;
	}

	public void setIdAvocat(Long idAvocat) {
		this.idAvocat = idAvocat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephoneFixe() {
		return telephoneFixe;
	}

	public void setTelephoneFixe(String telephoneFixe) {
		this.telephoneFixe = telephoneFixe;
	}

	public String getTelephoneMobile() {
		return telephoneMobile;
	}

	public void setTelephoneMobile(String telephoneMobile) {
		this.telephoneMobile = telephoneMobile;
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
		return "Avocat [idAvocat=" + idAvocat + ", nom=" + nom + ", prenom=" + prenom + ", telephoneFixe="
				+ telephoneFixe + ", telephoneMobile=" + telephoneMobile + ", email=" + email + ", adresse=" + adresse
				+ ", adresseComplement=" + adresseComplement + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}
	
	

}
