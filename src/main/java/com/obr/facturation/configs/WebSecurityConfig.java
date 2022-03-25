package com.obr.facturation.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.obr.facturation.jwt.AuthEntryPointJwt;
import com.obr.facturation.jwt.AuthTokenFilter;
import com.obr.facturation.services.UserDetailsImpl;
import com.obr.facturation.services.UserDetailsServiceImpl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;
//	UserDetailsServiceImpl userDetailsService;
	
	
//	public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) 
//	{
//		super();
//		this.userDetailsService = userDetailsService;
//	}
	
	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	
	

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() 
	{
		return new AuthTokenFilter();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		//authenticationManagerBuilder.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
		authenticationManagerBuilder
		.userDetailsService(userDetailsService())
        .passwordEncoder(passwordEncoder());
	}
	
	@Bean
	protected
	UserDetailsServiceImpl userDetailsService() {
	    return new UserDetailsServiceImpl();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
//			.antMatchers("/api/auth/signup").permitAll()
//			.antMatchers("/api/auth/login").permitAll()
//			.antMatchers("/api/test/**").permitAll()
//			.anyRequest().authenticated();
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
	
	@Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.cors().and().csrf().disable()
	      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	      .authorizeRequests().antMatchers("/api/**").permitAll()
	      .antMatchers("/api/**").permitAll()
	      .antMatchers("/api/signup").permitAll()
	      .antMatchers("/api/login").permitAll()
	      .antMatchers("/utilisateurs/**").permitAll()
//	      .antMatchers("/contribuables/**").permitAll()
//	      .antMatchers("/facture/**").permitAll()
	      .anyRequest().authenticated();	    

	    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	  }
	
}
