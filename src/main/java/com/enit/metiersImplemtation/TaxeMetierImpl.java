package com.enit.metiersImplemtation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.TaxeRepository;
import com.enit.entites.NomenclaturesTaxes;
import com.enit.entites.Taxe;
import com.enit.metiers.TaxeMetier;
@Component
public class TaxeMetierImpl implements TaxeMetier {
    @Autowired 
    private TaxeRepository taxeRepository ;
	@Override
	public Taxe consulterTaxe(String code) {
		return  taxeRepository.findById(code).get();
	}


	@Override
	public List<Taxe> listerTaxes() {
		
		return  taxeRepository.findAll();
	}

	@Override
	public boolean ajouterTaxe(Taxe taxe) {
		 try {
			      if(taxe!=null)
			      {
               	    taxeRepository.save(taxe);
        	    	  return true;
			      }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean supprimerTaxe(String code) {
		  Taxe taxe = consulterTaxe(code);
		  if(taxe!=null) {
			  taxeRepository.delete(taxe);
			  return true;
		  }
		return false;
	}

	@Override
	public boolean modifierTaxe(String code, Taxe taxe) {
        try {
			     Taxe t = taxeRepository.findById(code).get();
			     if(taxe!=null && t !=null) {
			    	 t.setAssiettes(taxe.getAssiettes());
			    	 t.setDesignation(taxe.getDesignation());
			    
			    	 t.setFormule(taxe.getFormule());
			    	 taxeRepository.save(t);
			    	 return true;
			     }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
