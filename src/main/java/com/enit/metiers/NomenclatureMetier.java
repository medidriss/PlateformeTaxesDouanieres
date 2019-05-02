package com.enit.metiers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.enit.entites.Nomenclature;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.SimulationUnitaire;

public interface NomenclatureMetier {
	public Nomenclature consulterNomenclatureParNdp(String ndp);
	public List<Nomenclature> consulterNomenclatureParGroupe(String numChapitre);
	public List<Nomenclature> consulterNomenclatureParMotCle(String mc);
	public List<Nomenclature> consulterTousNomenclatures();
	public boolean ajouterNomenclature(Nomenclature nomenclature);
	public boolean supprimerNomenclature(String ndp);
	public boolean ajouterSimulationUnitaireNomenclature(String ndp,SimulationUnitaire simulationUnitaire);
    public Page<Nomenclature> pagesNomenclatures(int page,int size);
    public void ajouterNomenclaturesTaxesNomenclature(String ndp, NomenclaturesTaxes nomenclaturesTaxes);
}
