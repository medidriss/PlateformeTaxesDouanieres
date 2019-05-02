package com.enit.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.enit.dao.NomenclaturesTaxesRepository;
import com.enit.entites.Chapitre;
import com.enit.entites.Nomenclature;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.NomenclaturesTaxesPK;
import com.enit.entites.Taxe;
import com.enit.metiers.ChapitreMetier;
import com.enit.metiers.NomenclatureMetier;
import com.enit.metiers.NomenclaturesTaxesMetier;
import com.enit.metiers.TaxeMetier;

@Controller
@RequestMapping(value="/nomenclature")
public class NomenclatureController {
	
    @Autowired
    private NomenclatureMetier nomenclatureMetier;
	@Autowired
	private ChapitreMetier chapitreMetier;
    @Autowired
    private TaxeMetier taxeMetier;
    @Autowired
    private NomenclaturesTaxesMetier nomenclaturesTaxesMetier; 
    @Secured(value= {"ROLE_ADMIN","ROLE_USER"})
	   @RequestMapping(value="/listeNomenclature")
	    public String  listeNomenclature(Model model,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="9")int size) {
	    	Page<Nomenclature> pages = nomenclatureMetier.pagesNomenclatures(page,size);
	    	model.addAttribute("pages",pages.getContent());
	    	
	    	int [] nbPages= new int[pages.getTotalPages()];
	    	for(int i=1 ;i<=nbPages.length;i++) {
	    		nbPages[i-1]=i;
	    	}
	    	model.addAttribute("nbPages",nbPages);
	    	model.addAttribute("size",size);
	    	model.addAttribute("pageCourant",page);
	    	
	    	return "listeNomenclature";
	    	
	    }

	   
	   @Secured(value= {"ROLE_ADMIN"})
		@RequestMapping(value="/ajouterNomenclature", method=RequestMethod.GET)
	    public ModelAndView ajouterNomenclatureForm() {
		      
			    Nomenclature nomenclature = new Nomenclature();
	            ModelAndView model = new ModelAndView("ajouterNomenclature","nomenclature",nomenclature);
	            model.addObject("listeChapitres",chapitreMetier.listerChapitre());
	            return model;		
		}
	   
	   @Secured(value= {"ROLE_ADMIN"})
		@RequestMapping(value="/supprimerNomenclature", method=RequestMethod.GET)
	    public ModelAndView supprimerNomenclatureForm() {
		      
			    Nomenclature nomenclature = new Nomenclature();
	            ModelAndView model = new ModelAndView("supprimerNomenclature","nomenclature",nomenclature);
	            return model;		
		}
	   @Secured(value= {"ROLE_ADMIN"})
		@RequestMapping(value="/supprimerNomenclature",method=RequestMethod.POST)
		public ModelAndView supprimerNomenclature(@Valid @ModelAttribute(name="nomenclature") Nomenclature nomenclature,BindingResult bindingResult) {
			if(bindingResult.hasFieldErrors("ndp")) {
				ModelAndView model =new ModelAndView("supprimerNomenclature");
	         	return model;
			}
			
		   try {
			    
			     Nomenclature n = nomenclatureMetier.consulterNomenclatureParNdp(nomenclature.getNdp());
			  
			     nomenclatureMetier.supprimerNomenclature(nomenclature.getNdp()); 
			     
				 ModelAndView model = new ModelAndView("redirect:/nomenclature/listeNomenclature");
				 return model;
			} catch (Exception e) {
				 
		            ModelAndView model = new ModelAndView("supprimerNomenclature","nomenclature",new Nomenclature());
		     
				model.addObject("message",e.getMessage());
				 return model;
			}
			
		}
	   @Secured(value= {"ROLE_ADMIN"})
		@RequestMapping(value="/ajouterNomenclature", method=RequestMethod.POST)
		public ModelAndView saveNomenclature (@Valid @ModelAttribute(name="nomenclature") Nomenclature nomenclature,BindingResult bindingResult) {
		    if(bindingResult.hasErrors()) {
		    	ModelAndView model =new ModelAndView("ajouterNomenclature");
	            model.addObject("listeChapitres",chapitreMetier.listerChapitre());

		    	return model;
		    }
			nomenclatureMetier.ajouterNomenclature(nomenclature);
			try {
				List<NomenclaturesTaxes> nomenclaturesTaxes = new ArrayList<NomenclaturesTaxes>();
			Chapitre chapitre = chapitreMetier.consulterChapitre(nomenclature.getChapitre().getNumChapitre());
			 String[] codesTaxes = chapitre.getCodesTaxes();
			 
			 for(String s:codesTaxes) {
			   Taxe t = taxeMetier.consulterTaxe(s);
               NomenclaturesTaxes n = new NomenclaturesTaxes(new NomenclaturesTaxesPK(t.getCode(),nomenclature.getNdp()), nomenclature, t);
               nomenclaturesTaxesMetier.ajouterNomenclaturesTaxes(n);
               nomenclaturesTaxes.add(n);
			   
			 }
			    nomenclature.setNomenclaturesTaxes(nomenclaturesTaxes);
				nomenclatureMetier.ajouterNomenclature(nomenclature);
				List<Nomenclature> listeNomenclatures=chapitre.getNomenclatures();
				listeNomenclatures.add(nomenclature);
				chapitre.setNomenclatures(listeNomenclatures);
				chapitreMetier.ajouterChapitre(chapitre);
		     	ModelAndView model=new	ModelAndView("redirect:/nomenclature/listeNomenclature");
				return model;
				
			} catch (Exception e) {
				ModelAndView model = new ModelAndView("ajouterNomenclature");
				model.addObject("nomenclature",nomenclature);
				model.addObject("message", e.getMessage());
				return model;
			}			
		}
		
}
