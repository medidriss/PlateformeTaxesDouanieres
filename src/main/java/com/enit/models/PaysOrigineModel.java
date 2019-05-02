package com.enit.models;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.enit.entites.PaysOrigine;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class PaysOrigineModel {
	@NotNull
	@Size(min=3,max=20)
    private String nomPays ;
    private double droitDouane;
    private String dd;
    private PaysOrigine paysOrigine;
    private List<PaysOrigine> listePays= new ArrayList<PaysOrigine>();
    private boolean verif= false; // pour verifier l etat de transaction
    private boolean submitted=false;  // pour verifier le soummettre 
    
}
