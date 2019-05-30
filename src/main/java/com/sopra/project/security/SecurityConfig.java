package com.sopra.project.security;



import java.util.Collection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sopra.project.model.*;
import com.sopra.project.repository.*;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"org.sid"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

@Autowired
	private UserDetailsService userDetailsService;
@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
RoleRepository roleRepository;
@Autowired
IGestionUrl iGestionUrl;


@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	/*auth.inMemoryAuthentication()
.withUser("admin").password("1234").roles("ADMIN","USER")
.and()
.withUser("user").password("1234").roles("USER");*/
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(bCryptPasswordEncoder);
	System.out.println("=============================config Authentication ===============================================");
	LOGGER.info("=============================config Authentication ===============================================");
}
@Override
	protected void configure(HttpSecurity http) throws Exception {
	System.out.println("*******************************Config autorization*******************************************");
	LOGGER.info("*******************************Config autorization*******************************************");
	http.csrf().disable();
	//désactiver la session:on a passer d'sys d'auth pa session a un sys d'auth par valeur
	
	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	//http.formLogin();
	http.authorizeRequests().antMatchers("/login/**").permitAll();
	http.authorizeRequests().antMatchers("/socket/**").permitAll();
	http.authorizeRequests().antMatchers("/api/materiel/getByIMEI").permitAll();
	http.authorizeRequests().antMatchers("/api/server").permitAll();
	http.authorizeRequests().antMatchers("/api/server/search").permitAll();
	http.authorizeRequests().antMatchers("/api/user/getAllUsers").permitAll();
	http.authorizeRequests().antMatchers("/api/projet/**").permitAll();
	http.authorizeRequests().antMatchers("/ws/**").permitAll();
	http.authorizeRequests().antMatchers("/topic/greeting").permitAll();
	http.authorizeRequests().antMatchers("/api/**").permitAll();
	http.authorizeRequests().antMatchers("/**").permitAll();



	

	


	

///
	
	Collection<AppRole> roles=roleRepository.findAll();
	//System.out.println("size ***********" + roles.get(0).getAccessUrls().size());

	// http.authorizeRequests().antMatchers("api/user/getall").denyAll();ù
	for (AppRole authority : roles) {

		String role = authority.getRoleName();
		//role = role.replaceAll("ROLE_", "");
		System.out.println(role);
		LOGGER.info("Role"+role );

		Collection<AccessUrl> accessUrls = authority.getAccessUrls();

		for (AccessUrl accessUrl : accessUrls) {
			// System.out.println(accessUrl.getGestionUrl().getGetallop());
			
			if (accessUrl.getAddop()) {
				 System.out.println("*************"+'"'+accessUrl.getGestionUrl().getAddop()+'"');

				http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getAddop()).toString()).hasAuthority(role.toString());
			System.out.println("http.authorizeRequests().antMatchers("+'"'+accessUrl.getGestionUrl().getAddop()+'"'+").hasAuthority(\""+role+"\");");
			LOGGER.info(accessUrl.getGestionUrl().getAddop(), http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getAddop()).toString()).hasAuthority(role.toString()));

			}
			
			if (accessUrl.getGetallop()) {
				 System.out.println("*************"+accessUrl.getGestionUrl().getGetallop());
				http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getGetallop()).toString()).hasAuthority(role.toString());
				System.out.println("http.authorizeRequests().antMatchers("+'"'+accessUrl.getGestionUrl().getGetallop()+'"'+").hasAuthority("+'"'+role+'"'+");");
				LOGGER.info(accessUrl.getGestionUrl().getGetallop(), http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getGetallop()).toString()).hasAuthority(role.toString()));

			}
			

			if (accessUrl.getGetbyidop()) {
				 System.out.println("*************"+accessUrl.getGestionUrl().getGetbyidop());

				http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getGetbyidop()).toString()).hasAuthority(role.toString());
			}
			if (accessUrl.getRemoveop()) {
				 System.out.println("*************"+accessUrl.getGestionUrl().getRemoveop());
				http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getRemoveop()).toString()).hasAuthority(role.toString());

			}
			if (accessUrl.getUpdateop()) {
				 System.out.println("*************"+accessUrl.getGestionUrl().getUpdateop());

				http.authorizeRequests().antMatchers((accessUrl.getGestionUrl().getUpdateop()).toString()).hasAuthority(role.toString());
			}
		}}


//	http.authorizeRequests().antMatchers("/tasks/add").hasAuthority("ADMIN");
	//http.authorizeRequests().antMatchers("/tasks/getall").hasAuthority("ADMIN");
	//http.authorizeRequests().antMatchers("/api/ronde/").hasAuthority("AGENT");
	http.authorizeRequests().antMatchers("/api/ronde/getall").hasAnyAuthority("CLIENT","AGENT","SUPERVISEUR","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/ronde/getbyid").hasAnyAuthority("AGENT","SUPERVISEUR","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/pointeau/add").hasAnyAuthority("AGENT","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/role/getall").hasAnyAuthority("CLIENT","AGENT","SUPERVISEUR","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/pointeau/add").hasAnyAuthority("AGENT","SUPERVISEUR","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/pointeau/getbyid").hasAnyAuthority("AGENT","SUPERVISEUR","CHEF DE POSTE");
	http.authorizeRequests().antMatchers("/api/user/getall").hasAnyAuthority("CLIENT","AGENT","SUPERVISEUR","CHEF DE POSTE");

	http.authorizeRequests().antMatchers("/api/server/").permitAll();


	//LOGGER.info("/api/ronde/getall");

	http.authorizeRequests().anyRequest().authenticated();
	http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	
	}

}
