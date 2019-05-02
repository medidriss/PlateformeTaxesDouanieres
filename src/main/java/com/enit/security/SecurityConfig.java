package com.enit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.enit.entites.User;
import com.enit.metiers.UserMetier;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled=true)

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
   
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
        auth.inMemoryAuthentication()
        .withUser("admin")
        .password(encoder().encode("azerty"))
        .roles("ADMIN");
 
	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/accounts/new").permitAll();  	   
     	   
		http
           	.authorizeRequests()
           	  .anyRequest()
           	   .authenticated()
           	   .and()
           	   .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home")
           	   .and()
           	.logout().permitAll().logoutUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").clearAuthentication(true);
        
	/*	http
	        .authorizeRequests()
	            .antMatchers("/login").permitAll()
	        .and()
	        .authorizeRequests()
	            .antMatchers("/accounts/new").permitAll()
	        .and()
	        .authorizeRequests()
	            .anyRequest().authenticated()
	        .and()
	        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout().permitAll().logoutUrl("/login?logout")
	     .logoutSuccessUrl("/login?logout").invalidateHttpSession(true).deleteCookies("JSESSIONID").clearAuthentication(true);
		*/
	}
	
	
	
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
