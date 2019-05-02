package com.enit.entites;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Document(collection="Nomenclature")

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Nomenclature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@NotEmpty
	@Size(min=11,max=11,message="NDP contient 11 chiffres")
	private String ndp;
	@NotEmpty
	@NotNull
   @TextIndexed
	private String designation;
    
	private List<NomenclaturesTaxes> nomenclaturesTaxes;
	private List<SimulationUnitaire> simulationsUnitaires;
	
	@NotNull
	@DBRef
	private Chapitre chapitre;
	public void addSimulationUnitaire(SimulationUnitaire simulationUnitaire) {
		 this.simulationsUnitaires.add(simulationUnitaire);
	}
	

	public Nomenclature(String ndp, String designation) {
		super();
		this.ndp = ndp;
		this.designation = designation;
	    this.nomenclaturesTaxes= new ArrayList<>();
	    this.simulationsUnitaires=new ArrayList<>();
	    
	}
	

	/*	
	public void addTaxe(Taxe t) {
		if(!taxes.contains(t)){
			taxes.add(t);
		}else {
			//??????
		}
	}
	*/
	
	public String getNdp() {
		return ndp;
	}
	public String getDesignation() {
		return designation;
	}
	public char getCle() {
		return ndp.charAt(ndp.length()-1);
	}
	public String getNGP() {
		return ndp.substring(0, ndp.length()-1);
	}
	public char getTarif() {
		return ndp.charAt(ndp.length()-3);
	}
	public String getUE() {
		return ndp.substring(0, ndp.length()-3);
	}
	public String getNSH() {
		return ndp.substring(0, ndp.length()-5);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((ndp == null) ? 0 : ndp.hashCode());
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
		Nomenclature other = (Nomenclature) obj;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (ndp == null) {
			if (other.ndp != null)
				return false;
		} else if (!ndp.equals(other.ndp))
			return false;
		return true;
	}


	public List<NomenclaturesTaxes> getNomenclaturesTaxes() {
		return nomenclaturesTaxes;
	}


	public void setNomenclaturesTaxes(List<NomenclaturesTaxes> nomenclaturesTaxes) {
		this.nomenclaturesTaxes = nomenclaturesTaxes;
	}


	public List<SimulationUnitaire> getSimulationsUnitaires() {
		return simulationsUnitaires;
	}


	public void setSimulationsUnitaires(List<SimulationUnitaire> simulationsUnitaires) {
		this.simulationsUnitaires = simulationsUnitaires;
	}


	public Chapitre getChapitre() {
		return chapitre;
	}


	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void setNdp(String ndp) {
		this.ndp = ndp;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	
	

	
	

}
