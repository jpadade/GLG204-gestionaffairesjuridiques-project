package com.adade.gestionaffairesjuridiques.ui.forms;

import java.util.Date;

import com.adade.gestionaffairesjuridiques.dto.ClientDTO;




public class CreateCustomerForm {
	
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

    public ClientDTO toDTO() {
    	ClientDTO dto = new ClientDTO();
    	dto.setCivilite(civilite);
    	dto.setNom(nom);
    	dto.setPrenom(prenom);
    	dto.setDateDeNaissance(dateDeNaissance);
    	dto.setDepartementDeNaissance(departementDeNaissance);
    	dto.setPaysDeNaissance(paysDeNaissance);
    	dto.setNationalite(nationalite);
    	dto.setEmail(email);
    	dto.setTelephoneFixe(telephoneFixe);
    	dto.setTelephoneMobile(telephoneMobile);
    	dto.setAdresse(adresse);
    	dto.setAdresseComplement(adresseComplement);
    	dto.setCodePostal(codePostal);
    	dto.setVille(ville);
    	return dto;
    	
        
    }
}
