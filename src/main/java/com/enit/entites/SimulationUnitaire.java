package com.enit.entites;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection="SimulationUnitaire")

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimulationUnitaire implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((paysOrigine == null) ? 0 : paysOrigine.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixAchat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantite);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		SimulationUnitaire other = (SimulationUnitaire) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (paysOrigine == null) {
			if (other.paysOrigine != null)
				return false;
		} else if (!paysOrigine.equals(other.paysOrigine))
			return false;
		if (Double.doubleToLongBits(prixAchat) != Double.doubleToLongBits(other.prixAchat))
			return false;
		if (Double.doubleToLongBits(quantite) != Double.doubleToLongBits(other.quantite))
			return false;
		return true;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private SimulationUnitaireKey  id;
	private PaysOrigine paysOrigine;
	private double quantite;
	private double prixAchat;
	private double montantUnitaire=0.0;
	
}
