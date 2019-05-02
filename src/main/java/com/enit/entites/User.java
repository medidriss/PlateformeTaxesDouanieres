package com.enit.entites;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Document(collection="User")
@Getter
@Setter

public class User {
	@Id
	@NotNull
	@Size(min=6,max=20)
	private String username;
	@NotNull
	@Size(min=6,max=30)
	
	private String password;
	private Role role;
	@NotNull
	@Size(min=4,max=20)
	private String nom;
	@NotNull
	@Size(min=4,max=20)
	private String prenom;
    @Email(message = "Email non valide")
    @NotNull
    @NotEmpty
	private String email;
	private boolean etatActivation;
	
	public User( ) {
		super();
		
		this.etatActivation=true;
		this.role = Role.ROLE_USER;
	}
	public User( String username, String password, String nom, String prenom,
			String email) {
		super();
	
		this.username=username;
		this.password = password;
		this.role = Role.ROLE_USER;
		this.nom = nom;
		this.prenom = prenom;
		
		this.email = email;
		this.etatActivation=true;
	}
	public User(String username, String password) {
		super();
		this.username=username;
		this.password = password;
		this.role = Role.ROLE_USER;
	
		this.etatActivation=true;
	}
	
	
	public boolean supprimerUser() {
		this.etatActivation=false;
		return true;
		
	}
	
	
	
}
