package com.adade.gestionaffairesjuridiques.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.adade.gestionaffairesjuridiques.common.exception.UsernameAlreadyExistsException;
import com.adade.gestionaffairesjuridiques.dao.UtilisateurDAO;
import com.adade.gestionaffairesjuridiques.domaine.Role;
import com.adade.gestionaffairesjuridiques.domaine.Utilisateur;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UtilisateurDAO utilisateurDAO;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Utilisateur> optUser = utilisateurDAO.findByLogin(username);
		 if (optUser.isPresent()) {
	            Utilisateur utilisateur = optUser.get();
	            UserBuilder builder = User.builder()
	                    .username(username)
	                    .password(utilisateur.getMotDePasse());
	            HashSet<String> roles = new HashSet<>();

	            switch (utilisateur.getRole()) {

	                case UTILISATEUR:
	                    roles.add("UTILISATEUR");
	                    break;
	                case ADMINISTRATEUR:
	                    roles.add("ADMINISTRATEUR");
	                default:
	                    break;
	            }
	            builder.roles(roles.toArray(new String[roles.size()]));
	            UserDetails details =  builder.build();
	            return details;
	        } else {
	            throw new UsernameNotFoundException(username);
	        }
		
	}
	
    public Utilisateur createUser(String username, String password, Role userRole) throws UsernameAlreadyExistsException {
      
    	Utilisateur user = new Utilisateur(username, password, userRole);
    	Long userId = user.getIdUtilisateur();
    	
        if (utilisateurDAO.existsById(userId)) {
            throw new UsernameAlreadyExistsException();
        }
        String encodedPassword = passwordEncoder.encode(password);
        Utilisateur newUser = new Utilisateur(username,encodedPassword,userRole);

        return utilisateurDAO.save(newUser);
    }

}
