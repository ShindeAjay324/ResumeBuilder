package com.resume;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings({ "deprecation", "unused" })
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsService service;
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(service);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	   @Override
	    public void configure(HttpSecurity http) throws Exception {
//	       http.csrf().disable().authorizeRequests()
//	        .antMatchers("/").permitAll()
//	        .antMatchers(HttpMethod.POST,"/register").permitAll()
//	        //.antMatchers(HttpMethod.POST, "/reumeInfo").permitAll()
//	        .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
//	        .antMatchers(HttpMethod.GET,"/master/*").permitAll()
//	         .antMatchers(HttpMethod.GET,"/exploreCourse").permitAll()
//	        .anyRequest().authenticated();
		   http.cors().and().csrf().disable();
	    }

}
