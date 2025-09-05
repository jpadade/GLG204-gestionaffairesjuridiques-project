package com.adade.gestionaffairesjuridiques.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

	/**
	 * Cette méthode est surtout intéressante parce qu'elle permet de
	 * "court-circuiter" Spring Security.
	 * 
	 * <p>
	 * On l'utilise principalement pour désactiver les tests sur certaines URL
	 * <em>avant</em> qu'on n'en arrive à vérifier en profondeur les choses.
	 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
		return (WebSecurity web) -> web.ignoring()
				.requestMatchers("/css/**");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
				.authorizeHttpRequests(a -> {
					//a.requestMatchers("/customer/create/**").hasAnyRole("ANONYMOUS","UTILISATEUR");
					a.requestMatchers("/admin/**").hasRole("ADMINISTRATEUR");
					a.requestMatchers("/office/**").hasAnyRole("UTILISATEUR","ADMINISTRATEUR" );
					a.anyRequest().permitAll();
		
					// mettre ici vos règles...
					// vous pouvez essayer dans un premier temps (pour une utilisation interactive)
					// de voir ce que ça donne si vous autorisez tout à tout le monde.
					
				})
				.formLogin(l -> l.loginPage("/login"))
		;
		return http.build();
	}

}
