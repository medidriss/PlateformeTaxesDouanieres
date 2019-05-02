package com.enit.metiersImplemtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.enit.dao.SimulationUnitaireRepository;
import com.enit.entites.Nomenclature;
import com.enit.entites.PaysOrigine;
import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;
import com.enit.metiers.NomenclatureMetier;
import com.enit.metiers.PaysOrigineMetier;
import com.enit.metiers.SimulationMetier;
import com.enit.metiers.SimulationUnitaireMetier;
@Component
public class SimulationUnitaireMetierImpl implements SimulationUnitaireMetier {
     @Autowired
     private SimulationUnitaireRepository simulationUnitaireRepository;
     @Autowired
     private PaysOrigineMetier paysOrigineMetier;
     @Autowired
     private NomenclatureMetier nomenclatureMetier;
     @Autowired
     private SimulationMetier simulationMetier;
	@Override
	public boolean ajouterSimulationUnitaire(SimulationUnitaire simulationUnitaire) {
		try {
			  if(simulationUnitaire!=null) {
				  simulationUnitaireRepository.save(simulationUnitaire);
				  return true;
			  }
		} catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public SimulationUnitaire consulterSimulationUnitaire(SimulationUnitaireKey simulationUnitaireKey) {
        try {
        	  SimulationUnitaire simulationUnitaire = simulationUnitaireRepository.findById(simulationUnitaireKey).get();
        	  if(simulationUnitaire!=null) {
        		  return simulationUnitaire ;
        	  }
			 
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return null;
	}


	@Override
	public boolean supprimerSimulationUnitaire(SimulationUnitaireKey simulationUnitaireKey) {
		try {
			  SimulationUnitaire simulationUnitaire = consulterSimulationUnitaire(simulationUnitaireKey);
			  if(simulationUnitaire!=null)
			  {
				  simulationUnitaireRepository.delete(simulationUnitaire);
				  return true;
			  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean modifierPrixAchat(SimulationUnitaireKey simulationUnitaireKey, double prix) {
		try {
			 SimulationUnitaire simulationUnitaire = consulterSimulationUnitaire(simulationUnitaireKey);
			  if(simulationUnitaire!=null) {
				   simulationUnitaire.setPrixAchat(prix);
				   simulationUnitaireRepository.save(simulationUnitaire);
				   return true;
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean modifierPaysOrigine(SimulationUnitaireKey simulationUnitaireKey, String pays) {
	    try {
	    	 SimulationUnitaire simulationUnitaire = consulterSimulationUnitaire(simulationUnitaireKey);
			  if(simulationUnitaire!=null) {
				   PaysOrigine paysOrigine = paysOrigineMetier.consulterPays(pays);
				   if(paysOrigine!=null) {
					   simulationUnitaire.setPaysOrigine(paysOrigine);
					   simulationUnitaireRepository.save(simulationUnitaire);
				   }
				  
				   return true;
			  }
	    	
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean modifierQuantite(SimulationUnitaireKey simulationUnitaireKey, double quantite) {
		try {
			 SimulationUnitaire simulationUnitaire = consulterSimulationUnitaire(simulationUnitaireKey);
			  if(simulationUnitaire!=null) {
				   simulationUnitaire.setQuantite(quantite);
				   simulationUnitaireRepository.delete(simulationUnitaire);
				   simulationUnitaireRepository.save(simulationUnitaire);
				   return true;
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}


	@Override
	public Page<SimulationUnitaire> listeSimulationsUnitairesParSimulation(String idSimulation,int page,int size) {
		
	return simulationUnitaireRepository.FindSimulationUnitaireBySimulation(idSimulation,new PageRequest(page, size));
	}

	@Override
	public boolean modifierMontantUnitaire(SimulationUnitaireKey simulationUnitaireKey, double montantUnitaire) {
		try {
			 SimulationUnitaire simulationUnitaire = consulterSimulationUnitaire(simulationUnitaireKey);
			  if(simulationUnitaire!=null) {
				   simulationUnitaire.setMontantUnitaire(montantUnitaire);
				   simulationUnitaireRepository.save(simulationUnitaire);
				   return true;
			  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<SimulationUnitaire> listeSimulationsUnitairesParIdSimulation(String idSimulation) {
	  return simulationUnitaireRepository.FindSimulationUnitaireBySimulation(idSimulation);
	}
	

}
