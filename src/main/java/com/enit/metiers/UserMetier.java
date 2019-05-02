package com.enit.metiers;

import java.util.List;

import com.enit.entites.Simulation;
import com.enit.entites.User;

public interface UserMetier {
    public List<User> consulterLesUsers();
    public User consulterUser(String username);
	public boolean ajouterUser(User user);
	public boolean supprimerUser( String username);
	public boolean modifierUser(String username, User user);
 
}
