package com.adade.gestionaffairesjuridiques.domaine;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String civilite;
	private String nom;
	private String prenom;
	private String dateDeNaissance;
	private String paysDeNaissance;
	private String departementDeNaissance;
	private String nationalite;
	private String telephoneFixe;
	private String telephoneMobile;
	private String email;
	private String adresse;
	private String adresseComplement;
	private String ville;
	private String codePostal;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(String civilite, String nom, String prenom, String telephoneMobile, String email) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.telephoneMobile = telephoneMobile;
		this.email = email;
	}

	public Client(Long idClient, String civilite, String nom, String prenom, String dateDeNaissance,
			String paysDeNaissance, String departementDeNaissance, String nationalite, String telephoneFixe,
			String telephoneMobile, String email, String adresse, String adresseComplement, String ville,
			String codePostal) {
		super();
		this.idClient = idClient;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.paysDeNaissance = paysDeNaissance;
		this.departementDeNaissance = departementDeNaissance;
		this.nationalite = nationalite;
		this.telephoneFixe = telephoneFixe;
		this.telephoneMobile = telephoneMobile;
		this.email = email;
		this.adresse = adresse;
		this.adresseComplement = adresseComplement;
		this.ville = ville;
		this.codePostal = codePostal;
	}

	public Long getIdclient() {
		return idClient;
	}

   public void setIdclient(Long idClient) {
		this.idClient = idClient;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
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

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getPaysDeNaissance() {
		return paysDeNaissance;
	}

	public void setPaysDeNaissance(String paysDeNaissance) {
		this.paysDeNaissance = paysDeNaissance;
	}

	public String getDepartementDeNaissance() {
		return departementDeNaissance;
	}

	public void setDepartementDeNaissance(String departementDeNaissance) {
		this.departementDeNaissance = departementDeNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
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
		return "Client [idClient=" + idClient + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateDeNaissance=" + dateDeNaissance + ", paysDeNaissance=" + paysDeNaissance
				+ ", departementDeNaissance=" + departementDeNaissance + ", nationalite=" + nationalite
				+ ", telephoneFixe=" + telephoneFixe + ", telephoneMobile=" + telephoneMobile + ", email=" + email
				+ ", adresse=" + adresse + ", adresseComplement=" + adresseComplement + ", ville=" + ville
				+ ", codePostal=" + codePostal + "]";
	}
	

}
