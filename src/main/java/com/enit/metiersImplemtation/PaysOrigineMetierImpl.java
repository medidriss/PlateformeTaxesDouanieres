package com.enit.metiersImplemtation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.enit.dao.PaysOrigineRepository;
import com.enit.entites.PaysOrigine;
import com.enit.metiers.PaysOrigineMetier;
@Component
public class PaysOrigineMetierImpl implements PaysOrigineMetier{
    @Autowired    
	private PaysOrigineRepository paysOrigineRepository;
	@Override
	public boolean ajouterPays(PaysOrigine paysOrigine) {
		  
		try {
			   if(paysOrigineRepository.save(paysOrigine) != null && paysOrigine!=null) {
				   return true;
			   }
		} catch (Exception e) {
			e.getMessage();
		     
		}
		return false;
	}

	@Override
	public boolean supprimerPays(String nomPays) {
        try {
        	  if( paysOrigineRepository.findById(nomPays)!=null)
        	  { 
        		  paysOrigineRepository.deleteById(nomPays);
        		  return true;
        		  
        	  }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<PaysOrigine> listerPays() {
		return paysOrigineRepository.findAll();
	
	}

	@Override
	public PaysOrigine consulterPays(String nomPays) {
		if(paysOrigineRepository.existsById(nomPays))
		{  return paysOrigineRepository.findById(nomPays).get();
		}
		return null;
	}

	@Override
	public boolean modifierPays(String nomPays, double droitDouane) {
		try {  
			 if(paysOrigineRepository.existsById(nomPays)) {
				 PaysOrigine p = new PaysOrigine(nomPays, droitDouane);
				 paysOrigineRepository.save(p);
				 return true;
			 }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
