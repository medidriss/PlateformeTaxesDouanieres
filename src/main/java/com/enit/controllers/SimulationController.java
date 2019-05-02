package com.enit.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.enit.entites.Nomenclature;
import com.enit.entites.PaysOrigine;
import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;
import com.enit.entites.User;
import com.enit.metiers.NomenclatureMetier;
import com.enit.metiers.PaysOrigineMetier;
import com.enit.metiers.SimulationMetier;
import com.enit.metiers.SimulationUnitaireMetier;
import com.enit.metiers.UserMetier;
import com.enit.models.MesSimulations;
import com.enit.models.SimulationModel;

@Controller
@RequestMapping(value="/simulation")
//@Secured(value= {"ROLE_USER"})
public class SimulationController {
 
	   @Autowired
	    private SimulationMetier simulationMetier;
		
	    @Autowired
	    private NomenclatureMetier nomenclatureMetier;

	    @Autowired
	    private SimulationUnitaireMetier simulationUnitaireMetier;
		@Autowired 
		private UserMetier userMetier;
		@Autowired
		private PaysOrigineMetier paysOrigineMetier;
	   
	
		

    @RequestMapping(value="/chercherNomenclature", method=RequestMethod.GET)
    public String chercheNomenclature(@ModelAttribute(name="SimulationModel") SimulationModel simulationModel,@RequestParam(name="simulation.idSimulation")String idSimulation,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="s",defaultValue="9")int s,@RequestParam(name="p",defaultValue="0")int p,@RequestParam(name="size",defaultValue="9")int size,@RequestParam(name="rechercheNDP",defaultValue="") String rechercheNDP ,@RequestParam(name="rechercheMotCle",defaultValue="") String rechercheMotCle,ModelMap model)
    {        
    	
    String currentUserName =null;	
  	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	if (!(authentication instanceof AnonymousAuthenticationToken)) {
	   currentUserName = authentication.getName();
	
	}
	User user =userMetier.consulterUser(currentUserName);
	if(user.getUsername().isEmpty()) {
			return "accessDenied";
		}
 	     Simulation simulation = simulationMetier.consulterSimulation(idSimulation);
 	   if(simulation.getUser().getUsername().equals(user.getUsername())) {
 		   
 	 
       	Page<Nomenclature> pages = nomenclatureMetier.pagesNomenclatures(page,size);
       	model.addAttribute("s",s);
    	model.addAttribute("p",p);
       
    	model.addAttribute("pages",pages.getContent());
    	
    	int [] nbPages= new int[pages.getTotalPages()];
    	for(int i=0 ;i<nbPages.length;i++) {
    		nbPages[i]=i;
    	}
    	Page<SimulationUnitaire> pageSimulationUnitaire =simulationUnitaireMetier.listeSimulationsUnitairesParSimulation(simulation.getIdSimulation(), p, s);
    	model.addAttribute("pageSimulationUnitaire",pageSimulationUnitaire.getContent());
    	int [] nbPagesSimulationUnitaire= new int[pageSimulationUnitaire.getTotalPages()];
    	for(int i=0 ;i<nbPagesSimulationUnitaire.length;i++) {
    		nbPagesSimulationUnitaire[i]=i;
    	}
    	
    	model.addAttribute("nbPagesSimulationUnitaire",nbPagesSimulationUnitaire);
    	model.addAttribute("nbPages",nbPages);
    	model.addAttribute("size",size);
    	model.addAttribute("page",page);
    	try {
    		 if(!rechercheNDP.isEmpty()&&(!idSimulation.isEmpty()))  {
            	 
            	 Nomenclature   nomenclature  = nomenclatureMetier.consulterNomenclatureParNdp(rechercheNDP);        
              
               if((nomenclature!=null) &&(simulation!=null))
               {   
                    SimulationUnitaireKey key = new SimulationUnitaireKey(nomenclature.getNdp(),simulation.getIdSimulation());
            	    
                    SimulationUnitaire simulationUnitaire = new SimulationUnitaire(key,new PaysOrigine("",0.0),0.0,0.0,0.0);

                
                    	 simulationUnitaireMetier.ajouterSimulationUnitaire(simulationUnitaire);
                         simulationMetier.ajouterSimulationUnitaire(idSimulation, simulationUnitaire);
                         nomenclatureMetier.ajouterSimulationUnitaireNomenclature(nomenclature.getNdp(), simulationUnitaire);
                         simulation = simulationMetier.consulterSimulation(simulation.getIdSimulation());
                             simulationModel.setSimulation(simulation);
                     
                    model.addAttribute("SimulationModel",simulationModel);
                     pageSimulationUnitaire =simulationUnitaireMetier.listeSimulationsUnitairesParSimulation(simulation.getIdSimulation(),p,s);
                	model.addAttribute("pageSimulationUnitaire",pageSimulationUnitaire.getContent());
                
                	for(int i=0 ;i<nbPagesSimulationUnitaire.length;i++) {
                		nbPagesSimulationUnitaire[i]=i;
                	}
                	
                	model.addAttribute("nbPagesSimulationUnitaire",nbPagesSimulationUnitaire);
                
                    
               }
              
        }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
        
    	return "chercherNomenclature";
 	   }
 	  else {
    	  return "accessDenied"; 
       }
    	
    }
    @RequestMapping(value="/mesSimulations",method=RequestMethod.GET)
    public String mesSimulations (Model model) {
      	
        String currentUserName =null;	
      	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	   currentUserName = authentication.getName();
    	
    	}
    	//User user =userMetier.consulterUser(currentUserName);
      	User user =userMetier.consulterUser("mohamed");
    	if(user.getUsername().isEmpty()) {
    			return "accessDenied";
    		}
    	
    	List<Simulation> mesSimulations = simulationMetier.listerSimulationsParUser(user);
    	MesSimulations simulations = new MesSimulations(mesSimulations);
    	model.addAttribute("simulations",simulations);
    	return "mesSimulations";
    }
  	@RequestMapping(value="/ajouterSimulation",method=RequestMethod.GET)
      public String ajouterSimulation(Model model ) {
        
  	       String currentUserName =null;	
          	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    		if (!(authentication instanceof AnonymousAuthenticationToken)) {
    		   currentUserName = authentication.getName();
    		
    		}
  		User user =userMetier.consulterUser(currentUserName);
  		if(user.getUsername().isEmpty()) {
  			return "accessDenied";
  		}
  		     Simulation simulation =new Simulation("Simulation", user);
  		    
  	         simulationMetier.ajouterSimulation(simulation);
  		     SimulationModel sModel = new SimulationModel();
  		     sModel.setSimulation(simulation);
  		    
  		   	Page<Nomenclature> pages = nomenclatureMetier.pagesNomenclatures(0,10);
  	       	model.addAttribute("s",6);
  	    	model.addAttribute("p",0);
  	       
  	    	model.addAttribute("pages",pages.getContent());
  	    	
  	    	int [] nbPages= new int[pages.getTotalPages()];
  	    	for(int i=0 ;i<nbPages.length;i++) {
  	    		nbPages[i]=i;
  	    	}
  	    
  	   
  	    	model.addAttribute("nbPages",nbPages);
  	    	model.addAttribute("size",9);
  	    	model.addAttribute("pageCourant",0);
  		    
  		      model.addAttribute("SimulationModel",sModel);
  			 return "ajouterSimulation";
  		 
  	
  	
  	}
      
    @RequestMapping(value="/saveSimulation",method=RequestMethod.POST)
    public ModelAndView saveSimulation(Model model,@ModelAttribute (name="SimulationModel") SimulationModel simulationModel ) {
        Simulation simulationForm = simulationModel.getSimulation();
        Simulation simulation = simulationMetier.consulterSimulation(simulationForm.getIdSimulation());
         simulation.setNomSimulation(simulationForm.getNomSimulation());
         simulation.setSimulationsUnitaires(simulationModel.getListeSimulationUnitaire());
         simulationMetier.ajouterSimulation(simulation);
         simulation = simulationMetier.consulterSimulation(simulation.getIdSimulation());
        List<SimulationUnitaire> liste = simulation.getSimulationsUnitaires();
        List<SimulationUnitaire> listeModel =simulationModel.getListeSimulationUnitaire();
  	   
       for (int i=0; i<liste.size();i++) {
    	  	 SimulationUnitaireKey key = new SimulationUnitaireKey(liste.get(i).getId().getNdp(),liste.get(i).getId().getIdSimulation());
        	 
        	 simulationUnitaireMetier.modifierQuantite(key,listeModel.get(i).getQuantite());
        	 simulationUnitaireMetier.modifierPaysOrigine(key,listeModel.get(i).getPaysOrigine().getNomPays());
        	 simulationUnitaireMetier.modifierPrixAchat(key,listeModel.get(i).getPrixAchat());
        	
        }
      
     
        simulationMetier.simulerCalcul(simulation.getIdSimulation());
        simulation=simulationMetier.consulterSimulation(simulation.getIdSimulation());
        
        simulationModel.setSimulation(simulation);
        simulationModel.setListeSimulationUnitaire(simulation.getSimulationsUnitaires());
        
     
    	return new ModelAndView("saveSimulation","SimulationModel",simulationModel);
      
      
    }
    
    
    
    @RequestMapping(value="/supprimerNdpDuListe",method=RequestMethod.GET)
    public String supprimerNdpDuListe(@RequestParam(name="idSimulation") String idSimulation,@RequestParam(name="ndp") String ndp ,Model model) {
	        
        String currentUserName =null;	
      	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	if (!(authentication instanceof AnonymousAuthenticationToken)) {
    	   currentUserName = authentication.getName();
    	
    	}
    	User user =userMetier.consulterUser(currentUserName);
    	if(user.getUsername().isEmpty()) {
    			return "accessDenied";
    		}
     	     Simulation simulation = simulationMetier.consulterSimulation(idSimulation);
     	   if(simulation.getUser().getUsername().equals(user.getUsername())) {
     		   
     	   
 
    	  if(simulation!=null) {
    		  simulationMetier.suprimerSimulatiionUnitaire(idSimulation, new SimulationUnitaireKey(ndp, idSimulation));
    	  }
    	 
    	  SimulationModel simulationModel = new SimulationModel();
    	   
          model.addAttribute("idSimulation", idSimulation);
    	  model.addAttribute("SimulationModel",simulationModel);
    	  return "redirect:/simulation/chercherNomenclature?simulation.idSimulation="+ idSimulation ;
     	   }   
     		return "accessDenied";
		 
	
	}
    @RequestMapping(value="/completerSimulationForm",method=RequestMethod.GET)
    public String completerSimulationForm( @RequestParam(name="idSimulation") String idSimulation,Model model,@ModelAttribute (name="SimulationModel") SimulationModel simulationModel) {
    	 String currentUserName =null;	
       	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     	if (!(authentication instanceof AnonymousAuthenticationToken)) {
     	   currentUserName = authentication.getName();
     	
     	}
     	User user =userMetier.consulterUser(currentUserName);
     	if(user.getUsername().isEmpty()) {
     			return "accessDenied";
     		}
      	     Simulation simulation = simulationMetier.consulterSimulation(idSimulation);
      	   if(simulation.getUser().getUsername().equals(user.getUsername())) {
      		   
    	
    	  simulationModel.setSimulation(simulation);
    	  simulationModel.setListeSimulationUnitaire(simulation.getSimulationsUnitaires());
    	  for(SimulationUnitaire s : simulation.getSimulationsUnitaires()) {
    		  simulationModel.addDesignation(s.getId().getNdp(),nomenclatureMetier.consulterNomenclatureParNdp(s.getId().getNdp()).getDesignation());
    	  }
    	  model.addAttribute("SimulationModel",simulationModel);
    	  List<PaysOrigine> listPays= paysOrigineMetier.listerPays();
    	  model.addAttribute("listPays",listPays);     

    	
    	return "completerSimulationForm";
      	   }
      	  
      	 return "accessDenied";
      
    }
    
  
}
