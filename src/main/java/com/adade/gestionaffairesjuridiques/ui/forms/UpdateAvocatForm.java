package com.adade.gestionaffairesjuridiques.ui.forms;

import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;



public class UpdateAvocatForm {
	
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
	
	public UpdateAvocatForm(AvocatDTO avocat) {
		this(avocat.getIdAvocat(),avocat.getNom(),avocat.getPrenom(),
				avocat.getEmail(),avocat.getTelephoneFixe(), avocat.getTelephoneMobile(),
				avocat.getAdresse(),avocat.getAdresseComplement(),avocat.getVille(),avocat.getCodePostal());
		
	}

	public UpdateAvocatForm(Long idAvocat, String nom, String prenom, String telephoneFixe, String telephoneMobile,
			String email, String adresse, String adresseComplement, String ville, String codePostal) {
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
	
	public UpdateAvocatForm() {
		
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
	public AvocatDTO toDTO(Long id) {
    	AvocatDTO dto = new AvocatDTO();
    	dto.setIdAvocat(id);
    	dto.setNom(nom);
    	dto.setPrenom(prenom);
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
