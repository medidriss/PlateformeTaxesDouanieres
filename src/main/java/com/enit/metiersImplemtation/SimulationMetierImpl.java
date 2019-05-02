package com.enit.metiersImplemtation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.SimulationRepository;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;
import com.enit.entites.Taxe;
import com.enit.entites.User;
import com.enit.metiers.NomenclaturesTaxesMetier;
import com.enit.metiers.SimulationMetier;
import com.enit.metiers.SimulationUnitaireMetier;
import com.enit.metiers.UserMetier;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
@Component
public class SimulationMetierImpl implements SimulationMetier{
  @Autowired
  private SimulationRepository simulationRepository;
  @Autowired
  private NomenclaturesTaxesMetier nomenclaturesTaxesMetier;
  @Autowired
  private UserMetier userMetier;
  @Autowired
  private SimulationUnitaireMetier simulationUnitaireMetier;
	@Override
	public List<Simulation> listerSimulations() {
         
		return simulationRepository.findAll();
	}

	@Override
	public Simulation consulterSimulation(String idSimulation) {
		try {
			  Simulation simulation =simulationRepository.findById(idSimulation).get();
			  if(simulation!=null)
			  {
				  return simulation;
			  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Simulation consulterSimulationParNom(String nomSimulation) {
		try {
			  Simulation simulation =simulationRepository.findSimulationByNomSimulation(nomSimulation);
			  if(simulation!=null)
			  {
				  return simulation;
			  }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Simulation> consulterSimulationParMotCle(String mc) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean ajouterSimulation(User user, String nomSimulation) {
		Simulation simulation = new Simulation(nomSimulation, user);
		 if(simulationRepository.save(simulation)!=null)
		 {
			 return true;
		 }
		 else return false;
		
	}

	@Override
	public boolean supprimerSimulation(String idSimulation) {
		try {   
			  Simulation s= consulterSimulation(idSimulation);
			  if(s!=null) {
				   s.supprimerSimulation();
				   for(SimulationUnitaire sUnitaire :s.getSimulationsUnitaires()) {
					   simulationUnitaireMetier.supprimerSimulationUnitaire(sUnitaire.getId());
				   }
				   return true;
			  }
			    
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean ajouterSimulationUnitaire(String idSimulation, SimulationUnitaire simulationUnitaire) {
		try {
			
			 Simulation simulation= simulationRepository.findById(idSimulation).get();
			 if(simulation!=null) {
				 List<SimulationUnitaire> l = simulation.getSimulationsUnitaires();
				 l.add(simulationUnitaire);
				 simulation.setSimulationsUnitaires(l);
				 simulationRepository.save(simulation);
				 return true;
			 }
			  
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean suprimerSimulatiionUnitaire(String idSimulation, SimulationUnitaireKey simulationUnitaireKey) {
	   try {
		     
		    SimulationUnitaire simulationUnitaire = simulationUnitaireMetier.consulterSimulationUnitaire(simulationUnitaireKey);
		    Simulation simulation = simulationRepository.findById(idSimulation).get();
		    if(simulation!=null) {
		    	List<SimulationUnitaire> list =simulation.getSimulationsUnitaires();
		    	 if(list.contains(simulationUnitaire)) {
		    		 list.remove(simulationUnitaire);
		    		 simulationRepository.save(simulation);
		    		 simulationUnitaireMetier.supprimerSimulationUnitaire(simulationUnitaireKey);
		    		 return true;
		    }
		   
		    	
		    }
	} catch (Exception e) {
		// TODO: handle exception
	}
	   return false;
	}

	@Override
	public double simulerCalcul(String idSimulation) {
	 try {
		   HashMap<String,Double> simulationUnitaireMontant= new HashMap<>();
		   Simulation simulation = consulterSimulation(idSimulation);
		   
		     List<SimulationUnitaire> simulationUnitaire = simulation.getSimulationsUnitaires();
		     double montant =0;
		     
		     for(SimulationUnitaire s :simulationUnitaire) {
		    	  double montantUnitaire=0;
		    	 List<NomenclaturesTaxes> listeTaxes = nomenclaturesTaxesMetier.consulterlisteNomenlaturesTaxesParNdp(s.getId().getNdp());
		    	  HashMap<String, Expression> formuleMap = new HashMap<>();
		    	  HashMap<Integer, ArrayList<String>> groupesMap =new HashMap<>() ;
		    	  
		    	  for (int i=0;i<6;i++)
		    	  {
		    		  groupesMap.put(i, new ArrayList<>());
		    	  }
		    	
		    	  
		    	  for (int i =0; i<listeTaxes.size();i++)
		    	   {    Taxe t = listeTaxes.get(i).getTaxe();   
		    	        String key = t.getCode() + t.getAssiettes().toString();
		    	        String formule =t.getFormule().toLowerCase();
		    	        String assiette = t.getAssiettes().toString().toLowerCase().substring(1,2);
		    	     
		    	        
		    		   formuleMap.put(key,new ExpressionBuilder(formule).variable(assiette).build());
		    		   for(int j=0; j<6;j++)
		    		   {
		    		     if(t.getCode().substring(0, 1).equals(String.valueOf(j)))
		    		     {
		    			   ArrayList<String> value = groupesMap.get(j);
		    			   value.add(key);
		    			   groupesMap.put(j, value);
		    		      }
		    		   
		    		   }
		    		  
		    	   }
		    	 
		    	   Iterator it= formuleMap.entrySet().iterator();
		           while(it.hasNext())
		           {
		        	   Map.Entry<String, Expression> pair =  (Entry<String, Expression>) it.next();
		    	       String key =pair.getKey();
		    	       String var = key.substring(4, 5).toLowerCase();
		    	       Expression  exp = pair.getValue();
		    	      
		    	       if(key.contains("A"))
		    	       { 
		    	    	 exp.setVariable(var,s.getPrixAchat()/100);
		    	    	 formuleMap.put(key,exp);
		    	    	 
		    	       }
		    	       
		    	       
		           }
		          
		           it= formuleMap.entrySet().iterator();
		           while(it.hasNext())
		           {
		        	   Map.Entry<String, Expression> pair =  (Entry<String, Expression>) it.next();
		    	       String key =pair.getKey();
		    	       String var = key.substring(4, 5).toLowerCase();
		    	       Expression  exp = pair.getValue();
		    	      
		    	       
		    	       if( key.contains("B"))
		    	       { 
		    	    	   double montantGroupeZero=0;
		    		       List<String> groupeZero = groupesMap.get(0);
		    		       for (String formule : groupeZero)
		    		       {
		    		    	   montantGroupeZero += formuleMap.get(formule).evaluate();
		    		       }
		    		      
		    		       exp.setVariable(var, (s.getPrixAchat()+montantGroupeZero)/100);
		    		       formuleMap.put(key, exp);
		    		      
		    	       }
		    	       
		           }
		           
		           it= formuleMap.entrySet().iterator();
		           while(it.hasNext())
		           {
		        	   Map.Entry<String, Expression> pair =  (Entry<String, Expression>) it.next();
		    	       String key =pair.getKey();
		    	       String var = key.substring(4, 5).toLowerCase();
		    	       
		    	       Expression  exp = pair.getValue();
		    	       
		    	   
		    	    	 if( key.contains("O"))
		    		       { 
		    		    	   double montantGroupes=0;
		    		    	   for(int i=0;i<6;i++) {
		    		    		  // if(i==4) {i++;}
		    		    		   List<String> groupe = groupesMap.get(i);
		    				       for (String formule : groupe)
		    				       {    if(!key.equals(formule)) {
		    				    	   montantGroupes += formuleMap.get(formule).evaluate();
		    				       }
		    				    	   
		    				                                                          
		    				    	  
		    				       } 
		    		    	   }
		    			      
		    			      
		    			       exp.setVariable(var, (s.getPrixAchat() + montantGroupes)/100);
		    			       formuleMap.put(key, exp);
		    			      
		    		       } 
		    	   }
		       
		           
		           it= formuleMap.entrySet().iterator();
		           while(it.hasNext())
		           {
		        	   Map.Entry<String, Expression> pair =  (Entry<String, Expression>) it.next();
		    	      montantUnitaire +=  pair.getValue().evaluate();
		    	    
		           }
		           montantUnitaire+=s.getPrixAchat();
		           
		           simulationUnitaireMontant.put(s.getId().getNdp(),montantUnitaire);
		           simulationUnitaireMetier.modifierMontantUnitaire(s.getId(), montantUnitaire);
		           
		           
		    	} 
		    	 
		     Iterator it= simulationUnitaireMontant.entrySet().iterator();
	           while(it.hasNext())
	           {
	        	   Map.Entry<String,Double> pair =  (Entry<String,Double>) it.next();
	        	   double prixTotale =  pair.getValue();
	        	   
	        	    prixTotale *= simulationUnitaireMetier.consulterSimulationUnitaire(new SimulationUnitaireKey(pair.getKey(), idSimulation)).getQuantite();
	    	       montant+= prixTotale;
	           }
	    simulation.setSimulationsUnitaires(simulationUnitaireMetier.listeSimulationsUnitairesParIdSimulation(simulation.getIdSimulation()));       
		simulation.setMontantTotale(montant);
		ajouterSimulation(simulation);
     return montant;		 
		 
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return 0;
	}

	
	@Override
	public boolean ajouterSimulation(Simulation simulation) {
		try {
			   if(simulation!=null)
			   {
				   simulationRepository.save(simulation);
				   return true;
			   }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Simulation> listerSimulationsParUser(User user) {
	  return simulationRepository.findSimulationByUser(user);
	}

}
