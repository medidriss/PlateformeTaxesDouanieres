package com.enit.metiers;

import java.util.List;

import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;
import com.enit.entites.User;

public interface SimulationMetier {
	public List<Simulation> listerSimulations();
	public List<Simulation> listerSimulationsParUser(User user);
	public Simulation consulterSimulation(String idSimulation);
	public Simulation consulterSimulationParNom(String nomSimulation);
	public List<Simulation> consulterSimulationParMotCle(String mc);
	public boolean ajouterSimulation(User user,String nomSimulation);
	public boolean ajouterSimulation(Simulation simulation);
    public boolean supprimerSimulation(String idSimulation);
    public boolean ajouterSimulationUnitaire(String idSimulation,SimulationUnitaire simulationUnitaire);
    public boolean suprimerSimulatiionUnitaire(String idSimulation, SimulationUnitaireKey simulationUnitaireKey);
    public double simulerCalcul(String idSimulation);
    
    

}
