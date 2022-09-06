package com.mydemo.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Configuration
//@EnableWebFluxSecurity
//@EnableWebSecurity

@EnableWebSecurity
public class Configuracao {
	
	private static StringBuffer sb = new StringBuffer("http://localhost:8080");
	private static final String LOGIN_PATH ="/login";

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
		http.authorizeHttpRequests().antMatchers("resources/***").permitAll();
		http.authorizeHttpRequests().antMatchers(HttpMethod.POST).denyAll();

	}
	
	protected void authenticate(final AuthenticationManagerBuilder auth) throws Exception{
	
		String login = System.getenv("user");
		String pass = System.getenv("pass");
		
		//UserDetailsService userDetails = 
	}
	
	
	protected void configure(WebSecurity security)throws Exception {
		
		//security.getPrivilegeEvaluator().isAllowed(LOGIN_PATH,auth)
		
	}

	

}




	
