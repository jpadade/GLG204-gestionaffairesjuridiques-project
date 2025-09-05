package com.adade.gestionaffairesjuridiques.dto;

import com.adade.gestionaffairesjuridiques.domaine.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UtilisateurDTO {
	
	private Long idUtilisateur;
    private String login;
    private String motDePasse;
    private String nom;
    private String prenom;
    private String role;
    
	public UtilisateurDTO() {
		// TODO Auto-generated constructor stub
	}

	public UtilisateurDTO(Long idUtilisateur, String login, String motDePasse, String nom, String prenom, String role) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.login = login;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UtilisateurDTO [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePasse=" + motDePasse
				+ ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + "]";
	}

}
