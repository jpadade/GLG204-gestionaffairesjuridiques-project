package com.adade.gestionaffairesjuridiques.ui.forms;

import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;

public class UpdateJuridictionForm {
	
	private Long idJuridiction;
	private String nom;
	private String telephone;
	private String fax;
	private String email;
	private String adresse;
	private String adresseComplement;
	private String ville;
	private String codePostal;
	
	
	public UpdateJuridictionForm(JuridictionDTO j) {
		this(j.getIdJuridiction(),j.getNom(),
				j.getEmail(),j.getTelephone(), j.getFax(),
				j.getAdresse(),j.getAdresseComplement(),j.getVille(),j.getCodePostal());
		
	}


	public UpdateJuridictionForm(Long idJuridiction, String nom, String telephone, String fax, String email,
			String adresse, String adresseComplement, String ville, String codePostal) {
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
	
	public UpdateJuridictionForm() {
		
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
	
    public JuridictionDTO toDTO(Long id) {
    	JuridictionDTO dto = new JuridictionDTO();	
    	dto.setIdJuridiction(id);
    	dto.setNom(nom);
    	dto.setEmail(email);
    	dto.setTelephone(telephone);
    	dto.setFax(fax);
    	dto.setAdresse(adresse);
    	dto.setAdresseComplement(adresseComplement);
    	dto.setCodePostal(codePostal);
    	dto.setVille(ville);
    	return dto;	
        
    }

}
