package com.adade.gestionaffairesjuridiques.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="user")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;

    @Column(name = "username")
    private String login;
    
    @Column(name = "userpassword")
    private String motDePasse;
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private Role role;

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String login, String motDePasse, String nom, String prenom, Role role) {

		this.login = login;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.role = role;
	}
	public Utilisateur(String login, String motDePasse, Role role) {

		this.login = login;
		this.motDePasse = motDePasse;
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", login=" + login + ", motDePasse=" + motDePasse
				+ ", nom=" + nom + ", prenom=" + prenom + ", role=" + role + "]";
	}

}
