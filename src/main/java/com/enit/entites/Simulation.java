package com.enit.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(collection="Simulation")
@Getter
@Setter

public class Simulation implements Serializable{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateSimulation == null) ? 0 : dateSimulation.hashCode());
		result = prime * result + (etatSimulation ? 1231 : 1237);
		result = prime * result + ((idSimulation == null) ? 0 : idSimulation.hashCode());
		long temp;
		temp = Double.doubleToLongBits(montantTotale);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nomSimulation == null) ? 0 : nomSimulation.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Simulation other = (Simulation) obj;
		if (dateSimulation == null) {
			if (other.dateSimulation != null)
				return false;
		} else if (!dateSimulation.equals(other.dateSimulation))
			return false;
		if (etatSimulation != other.etatSimulation)
			return false;
		if (idSimulation == null) {
			if (other.idSimulation != null)
				return false;
		} else if (!idSimulation.equals(other.idSimulation))
			return false;
		if (Double.doubleToLongBits(montantTotale) != Double.doubleToLongBits(other.montantTotale))
			return false;
		if (nomSimulation == null) {
			if (other.nomSimulation != null)
				return false;
		} else if (!nomSimulation.equals(other.nomSimulation))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1241248337806187770L;
	/**
	 * 
	 */

	@Id
	private String idSimulation;

	private String nomSimulation;
	private double montantTotale;
	private boolean etatSimulation;
  
	private Date dateSimulation ;
	private User user;	
	private List<SimulationUnitaire> simulationsUnitaires;
	public boolean supprimerSimulation() {
		try {
			this.etatSimulation=false;
			
			return true;  // avec succes
		} catch (Exception e) {
		  e.getMessage();
		}
		return false; // avec echec 
	}
	/*
	for test */
	
	public Simulation() {
		
		super();
	
		// TODO Auto-generated constructor stub
	}
	
    
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Simulation(String nomSimulation, User user) {
		super();
	
		this.nomSimulation = nomSimulation;
		this.user = user;
		this.etatSimulation=true;
	    this.simulationsUnitaires=new ArrayList<SimulationUnitaire>();
		montantTotale=0;
		this.dateSimulation=new Date();
	}

	
}
