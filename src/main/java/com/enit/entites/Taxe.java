package com.enit.entites;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection="Taxes")
@Getter
@Setter

public class Taxe {
	@Id
	private String code;
	private String designation;
	private List<Character> assiettes;
	private String formule;
 
  
	public String getFormule() {
		return formule;
	}
	public void setFormule(String formule) {
		this.formule = formule;
	}
	public Taxe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxe(String code, String designation, List<Character> assiettes) {
		super();
		this.code = correctCode(code);
		this.designation = designation;
		this.assiettes = assiettes;
		updateFormule();
	}
	
	private String correctCode(String nc) {
		nc =  nc.trim();
		int nbZeros = 3 - nc.length();
		if(nbZeros>0) {
			StringBuilder sb = new StringBuilder();
			sb.append('0');
			if(nbZeros>1) {
				sb.append('0');				
			}
			sb.append(nc);
			nc = sb.toString();
		}
		return nc;
	}
	
	private void updateFormule() {
		StringBuilder sb = new StringBuilder();
		for(char a : assiettes) {//formule = p_A*A + p_B*B
			sb.append(" + t");
			sb.append(a);
			sb.append(" * ");
			sb.append(a);
		}
		if(sb.length()>0) {
			sb.deleteCharAt(sb.indexOf("+"));			
		}
		formule = sb.toString().trim();
	}
	public String getCode() {
		return code;
	}

	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Character> getAssiettes() {
		return assiettes;
	}
	public void setAssiettes(List<Character> assiettes) {
		this.assiettes = assiettes;
		updateFormule();
	}
	@Override
	public String toString() {
		return "Taxe [code=" + code + ", designation=" + designation + ", assiettes=" + assiettes.toString() + ", formule="
				+ formule + ", nomenclaturesTaxes="  + "]";
	}
	
	
	

}
