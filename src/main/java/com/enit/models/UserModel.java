package com.enit.models;

import java.util.ArrayList;
import java.util.List;

import com.enit.entites.Role;
import com.enit.entites.User;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserModel {

	private String username;
	private String password;

	private String nom;
	private String prenom;

	private String email;
	private boolean etatActivation;
	private List<User> listeUsers = new ArrayList<>();
	private boolean verif;
	private boolean submitted;
}
