package com.enit.metiers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;

import com.enit.entites.Nomenclature;
import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;

public interface SimulationUnitaireMetier {
public boolean ajouterSimulationUnitaire(SimulationUnitaire simulationUnitaire);
public SimulationUnitaire consulterSimulationUnitaire(SimulationUnitaireKey simulationUnitaireKey);
public boolean supprimerSimulationUnitaire(SimulationUnitaireKey simulationUnitaireKey);
public boolean modifierPrixAchat(SimulationUnitaireKey simulationUnitaireKey,double prix);
public boolean modifierPaysOrigine(SimulationUnitaireKey simulationUnitaireKey,String pays);
public boolean modifierQuantite(SimulationUnitaireKey simulationUnitaireKey, double quantite);
public boolean modifierMontantUnitaire(SimulationUnitaireKey simulationUnitaireKey, double montantUnitaire);
public Page<SimulationUnitaire> listeSimulationsUnitairesParSimulation (String idSimulation,int page, int size);
public List<SimulationUnitaire> listeSimulationsUnitairesParIdSimulation(String idSimulation);

    
}
