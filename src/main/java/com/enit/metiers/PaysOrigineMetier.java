package com.enit.metiers;

import java.util.List;

import com.enit.entites.PaysOrigine;

public interface PaysOrigineMetier {
	public boolean ajouterPays(PaysOrigine paysOrigine);
	public boolean supprimerPays(String nomPays);
	public List<PaysOrigine> listerPays();
	public PaysOrigine consulterPays(String nomPays);
	public boolean modifierPays(String nomPays, double droitDouane);

}
