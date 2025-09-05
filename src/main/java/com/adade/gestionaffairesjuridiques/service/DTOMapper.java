package com.adade.gestionaffairesjuridiques.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.adade.gestionaffairesjuridiques.domaine.Affaire;
import com.adade.gestionaffairesjuridiques.domaine.Avocat;
import com.adade.gestionaffairesjuridiques.domaine.Client;
import com.adade.gestionaffairesjuridiques.domaine.Document;
import com.adade.gestionaffairesjuridiques.domaine.Juridiction;
import com.adade.gestionaffairesjuridiques.domaine.Role;
import com.adade.gestionaffairesjuridiques.domaine.Tache;
import com.adade.gestionaffairesjuridiques.domaine.TypeAffaire;
import com.adade.gestionaffairesjuridiques.domaine.Utilisateur;
import com.adade.gestionaffairesjuridiques.dto.AffaireDTO;
import com.adade.gestionaffairesjuridiques.dto.AvocatDTO;
import com.adade.gestionaffairesjuridiques.dto.ClientDTO;
import com.adade.gestionaffairesjuridiques.dto.DocumentDTO;
import com.adade.gestionaffairesjuridiques.dto.JuridictionDTO;
import com.adade.gestionaffairesjuridiques.dto.TacheDTO;
import com.adade.gestionaffairesjuridiques.dto.TypeAffaireDTO;
import com.adade.gestionaffairesjuridiques.dto.UtilisateurDTO;



@Service
public class DTOMapper {
/*

 */

    public static ClientDTO toDTO(Client client) {
        return new ClientDTO(client.getIdclient(),client.getCivilite(), client.getNom(),client.getPrenom(), client.getDateDeNaissance(),
        		client.getPaysDeNaissance(), client.getDepartementDeNaissance(), client.getNationalite(), client.getTelephoneFixe(),
        		client.getTelephoneMobile(),client.getEmail(), client.getAdresse(), client.getAdresseComplement(), client.getVille(), client.getCodePostal());
    }
    
    public static AvocatDTO toDTO(Avocat avocat) {
    	return new AvocatDTO(avocat.getIdAvocat(), avocat.getNom(), avocat.getPrenom(), avocat.getTelephoneFixe(), 
    			avocat.getTelephoneMobile(), avocat.getEmail(),avocat.getAdresse(), avocat.getAdresseComplement(),
    			avocat.getVille(), avocat.getCodePostal());	
    }
    
    public static DocumentDTO toDTO(Document document) {
    	return new DocumentDTO(document.getIdDocument(), document.getNomDocument(), document.getDescription(), document.getTypeDocument(), document.getLienFichier(), document.getStatut());
    	
    }
    
    public static JuridictionDTO toDTO(Juridiction juridiction) {
    	return new JuridictionDTO(juridiction.getIdJuridiction(), juridiction.getNom(), juridiction.getTelephone(),
    			juridiction.getFax(), juridiction.getEmail(), juridiction.getAdresse(), juridiction.getAdresseComplement(),
    			juridiction.getVille(), juridiction.getCodePostal());
    }
    
    public static TacheDTO toDTO(Tache tache) {
    	Affaire affaire =tache.getAffaire();
    	Avocat  avocat =tache.getAvocat();
    	return new TacheDTO(tache.getIdTache(), tache.getIntitule(),tache.getTarifHoraire(), tache.getNbHeures(),
    			tache.getMontantTotal(),tache.getDateDebut(), tache.getDateFin(),affaire.getNomAffaire(),avocat.getNom());
   	
    }
    
    public static TypeAffaireDTO toDTO(TypeAffaire typeAffaire) {
    	return new TypeAffaireDTO(typeAffaire.getIdTypeAffaire(), typeAffaire.getLibelle());
    	
    	
    }
    
    public static UtilisateurDTO toDTO(Utilisateur utilisateur) {
    	Role role=utilisateur.getRole();
    	return new UtilisateurDTO(utilisateur.getIdUtilisateur(),utilisateur.getLogin(), utilisateur.getMotDePasse(),
    			utilisateur.getNom(), utilisateur.getPrenom(), role.name());
    }
    
    public static AffaireDTO toDTO(Affaire affaire) {
    	Avocat avocat = affaire.getAvocat();
    	Juridiction juridiction = affaire.getJuridication();
    	Client client = affaire.getClient();
    	TypeAffaire typeAffaire = affaire.getTypeAffaire();
    	return new AffaireDTO(affaire.getIdAffaire(), affaire.getNomAffaire(),affaire.getNumeroAffaire(), affaire.getPartieAdverse(), affaire.getStatut(), avocat.getNom(), juridiction.getNom(), client.getNom(), typeAffaire.getLibelle(),affaire.getDocuments().toString());
    }
    
    
    public void fillClientFromDTO(Client client, ClientDTO clientDTO) {
    	
    	client.setCivilite(clientDTO.getCivilite());
    	client.setNom(clientDTO.getNom());
    	client.setPrenom(clientDTO.getPrenom());
    	client.setDateDeNaissance(clientDTO.getDateDeNaissance());
    	client.setDepartementDeNaissance(clientDTO.getDepartementDeNaissance());
    	client.setPaysDeNaissance(clientDTO.getPaysDeNaissance());
    	client.setNationalite(clientDTO.getNationalite());
    	client.setEmail(clientDTO.getEmail());
    	client.setTelephoneFixe(clientDTO.getTelephoneFixe());
    	client.setTelephoneMobile(clientDTO.getTelephoneMobile());
    	client.setAdresse(clientDTO.getAdresse());
    	client.setAdresseComplement(clientDTO.getAdresseComplement());
    	client.setCodePostal(clientDTO.getCodePostal());
    	client.setVille(clientDTO.getVille());
    	
    }
    
    
    public void fillClientUpdateFromDTO(Client client, ClientDTO clientDTO) {
    	
    	client.setIdclient(clientDTO.getIdClient());
    	client.setCivilite(clientDTO.getCivilite());
    	client.setNom(clientDTO.getNom());
    	client.setPrenom(clientDTO.getPrenom());
    	client.setDateDeNaissance(clientDTO.getDateDeNaissance());
    	client.setDepartementDeNaissance(clientDTO.getDepartementDeNaissance());
    	client.setPaysDeNaissance(clientDTO.getPaysDeNaissance());
    	client.setNationalite(clientDTO.getNationalite());
    	client.setEmail(clientDTO.getEmail());
    	client.setTelephoneFixe(clientDTO.getTelephoneFixe());
    	client.setTelephoneMobile(clientDTO.getTelephoneMobile());
    	client.setAdresse(clientDTO.getAdresse());
    	client.setAdresseComplement(clientDTO.getAdresseComplement());
    	client.setCodePostal(clientDTO.getCodePostal());
    	client.setVille(clientDTO.getVille());
    	
    }
    
    public void fillAvocatFromDTO(Avocat avocat, AvocatDTO avocatDTO) {
    	
    	
    	avocat.setNom(avocatDTO.getNom());
    	avocat.setPrenom(avocatDTO.getPrenom()); 
    	avocat.setEmail(avocatDTO.getEmail());
    	avocat.setTelephoneFixe(avocatDTO.getTelephoneFixe());
    	avocat.setTelephoneMobile(avocatDTO.getTelephoneMobile());
    	avocat.setAdresse(avocatDTO.getAdresse());
    	avocat.setAdresseComplement(avocatDTO.getAdresseComplement());
    	avocat.setCodePostal(avocatDTO.getCodePostal());
    	avocat.setVille(avocatDTO.getVille());
    	
    }
    
    public void fillAvocatUpdateFromDTO(Avocat avocat, AvocatDTO avocatDTO) {
    	
    	avocat.setIdAvocat(avocatDTO.getIdAvocat());
    	avocat.setNom(avocatDTO.getNom());
    	avocat.setPrenom(avocatDTO.getPrenom()); 
    	avocat.setEmail(avocatDTO.getEmail());
    	avocat.setTelephoneFixe(avocatDTO.getTelephoneFixe());
    	avocat.setTelephoneMobile(avocatDTO.getTelephoneMobile());
    	avocat.setAdresse(avocatDTO.getAdresse());
    	avocat.setAdresseComplement(avocatDTO.getAdresseComplement());
    	avocat.setCodePostal(avocatDTO.getCodePostal());
    	avocat.setVille(avocatDTO.getVille());
    	
    }
    
    public void fillJuridictionFromDTO(Juridiction j, JuridictionDTO juridictionDTO) {
    	   	
    	j.setNom(juridictionDTO.getNom());
    	j.setEmail(juridictionDTO.getEmail());
    	j.setTelephone(juridictionDTO.getTelephone());
    	j.setFax(juridictionDTO.getFax());
    	j.setAdresse(juridictionDTO.getAdresse());
    	j.setAdresseComplement(juridictionDTO.getAdresseComplement());
    	j.setCodePostal(juridictionDTO.getCodePostal());
    	j.setVille(juridictionDTO.getVille());
    	
    }
    
    public void fillJuridictionUpdateFromDTO(Juridiction j, JuridictionDTO juridictionDTO) {
	   	
    	j.setIdJuridiction(juridictionDTO.getIdJuridiction());
    	j.setNom(juridictionDTO.getNom());
    	j.setEmail(juridictionDTO.getEmail());
    	j.setTelephone(juridictionDTO.getTelephone());
    	j.setFax(juridictionDTO.getFax());
    	j.setAdresse(juridictionDTO.getAdresse());
    	j.setAdresseComplement(juridictionDTO.getAdresseComplement());
    	j.setCodePostal(juridictionDTO.getCodePostal());
    	j.setVille(juridictionDTO.getVille());
    	
    }
}
