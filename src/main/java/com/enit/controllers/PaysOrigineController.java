package com.enit.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enit.entites.PaysOrigine;
import com.enit.metiers.PaysOrigineMetier;
import com.enit.models.PaysOrigineModel;

@Controller
@RequestMapping(value="/paysorigine")
public class PaysOrigineController {
	@Autowired
	private PaysOrigineMetier paysOrigineMetier;
	
	
	@RequestMapping(value="/listePays")
	public String listerPays(Model model) {
		 PaysOrigineModel paysOrigineModel = new PaysOrigineModel() ;
		
		paysOrigineModel.setListePays(paysOrigineMetier.listerPays());
		
		 model.addAttribute("PaysOrigineModel",paysOrigineModel);
		 return "listePays" ;
	}
	@RequestMapping(value="/ajouterPays", method=RequestMethod.GET)
	public String ajouterPays(Model model) {
		    PaysOrigineModel paysModel = new PaysOrigineModel();
		   paysModel.setSubmitted(false); paysModel.setVerif(false);
 		 model.addAttribute("PaysOrigineModel", paysModel);
		 return "ajouterPays" ;
		
	}
	@RequestMapping(value="/savePays" , method=RequestMethod.POST)
	public String savePays(Model model ,@Valid @ModelAttribute PaysOrigineModel paysModel,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
        	model.addAttribute("PaysOrigineModel",paysModel);
        	return "ajouterPays";
        }
	    String nomPays = paysModel.getNomPays();
	    double droitDouane = paysModel.getDroitDouane();
	    try {
	    	
	    	 if(!nomPays.isEmpty() && !Double.isNaN(droitDouane)) {
	    		 paysOrigineMetier.ajouterPays(new PaysOrigine(nomPays, droitDouane));
	    		 paysModel.setVerif(true);
	    		 paysModel.setSubmitted(true);
	    		 model.addAttribute("PaysOrigineModel",paysModel);
	    		 return "ajouterPays";
	    	 }
			
		} catch (Exception e) {
			// TODO: handle exception
		} paysModel.setSubmitted(true);	    
		 paysModel.setVerif(false);
		 model.addAttribute("PaysOrigineModel",paysModel);
	    return "ajouterPays" ;
	}
	
	

	@RequestMapping(value="/supprimerPaysOrigine",method=RequestMethod.GET)
	public String supprimerPaysOrigine(Model model ,HttpServletRequest request , RedirectAttributes redirectAttributes) {
	    PaysOrigineModel paysOrigineModel = new PaysOrigineModel();
                String nomPays = request.getParameter("nomPays");
		   try {
			       if(paysOrigineMetier.consulterPays(nomPays)!=null) {
			    	    paysOrigineMetier.supprimerPays(nomPays);
			    	    paysOrigineModel.setVerif(true);
			    	    paysOrigineModel.setSubmitted(true);
			    	    redirectAttributes.addAttribute("PaysOrigineModel", paysOrigineModel);
			    	    return "listePays";
			       }
		} catch (Exception e) {
			// TODO: handle exception
		}
		   paysOrigineModel.setVerif(false);
   	       paysOrigineModel.setSubmitted(false);
		   model.addAttribute("PaysOrigineModel", paysOrigineModel);
   	       return "redirect:listePays";
	}
	
	@RequestMapping(value="/modifierPaysOrigineForm",method=RequestMethod.GET)
	public ModelAndView modifierPaysOrigineForm(@RequestParam String nomPays) {
	           
	           
               
		    try {
			      PaysOrigine paysOrigine = paysOrigineMetier.consulterPays(nomPays);
			      if(paysOrigine!=null)
			      {
			    	  return new ModelAndView("modifierPays","PaysOrigineModel",paysOrigine);
			      }
			       
		} catch (Exception e) {
			// TODO: handle exception
		}
		    return null;
		
	}
	 @RequestMapping(value="/savePaysModification",method=RequestMethod.POST)
     public ModelAndView savePaysOrigineModification(@ModelAttribute(name="PaysOrigineModel") PaysOrigineModel paysOrigineModel) {
    	  
		 PaysOrigine paysOrigine = paysOrigineMetier.consulterPays(paysOrigineModel.getNomPays());
		 
		 
		 if(paysOrigine!=null)
		 {
			
				 paysOrigine.setNomPays(paysOrigineModel.getNomPays());
				 paysOrigine.setDroitDouane(paysOrigineModel.getDroitDouane());
				paysOrigineMetier.ajouterPays(paysOrigine);
				 return new ModelAndView("redirect:/paysorigine/listePays");
			 }
		 
		 
		 
		 return new ModelAndView("redirect:/home/ajouterPays");
    	 
    	 
     }
}
