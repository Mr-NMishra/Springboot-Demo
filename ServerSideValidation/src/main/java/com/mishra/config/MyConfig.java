package com.mishra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter { 

	//creating bean of USERDETAILSERVICE which retrun our implemented class.
	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailServiceImpl();
	}
	
	//we also created password encoder-dcriptor bean
	@Bean 
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(this.getUserDetailService());
		authenticationProvider.setPasswordEncoder(this.passwordEncoder());
		return authenticationProvider;
	}

	//Configure methods 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//this is for DATABASE AUthntication type if we want to use memory base 
		//then we use 		auth.inMemoryAuthentication() method
		auth.authenticationProvider(authenticationProvider());
	}

	//now telling which url is to protect
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasRole("USER").antMatchers("/**").permitAll().and().
		formLogin().loginPage("/login").loginProcessingUrl("/dologin").defaultSuccessUrl("/user/index").failureUrl("/")
		.and().csrf().disable();
		//super.configure(http);
	}
//	
//	
//	
	
	

	
}
