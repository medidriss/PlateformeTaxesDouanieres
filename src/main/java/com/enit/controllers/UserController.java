package com.enit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enit.entites.User;
import com.enit.metiers.UserMetier;
import com.enit.models.UserModel;

import lombok.val;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired 
	private UserMetier userMetier; 
	 
    @RequestMapping(value="/modifierUserForm",method=RequestMethod.GET)
	public  ModelAndView modifierUser(@RequestParam String username)
	{
	       User user = userMetier.consulterUser(username);
	  if(user!=null) {
		  return new ModelAndView("modifierUser","UserModel",user);
	  }
	return null;
		
	}
	
	@RequestMapping(value="/modifierUser",method=RequestMethod.POST)
	public ModelAndView saveModification(@ModelAttribute(name="UserModel")UserModel userModel)
	{
	      User user = userMetier.consulterUser(userModel.getUsername());
	      if(user!=null) {
	    	  if(!userModel.getEmail().isEmpty()) {
	    		  user.setEmail(userModel.getEmail());
	    	  }
	    	  if(!userModel.getNom().isEmpty()) {
	    		  user.setNom(userModel.getNom());
	    	  }
	    	  if(!userModel.getPassword().isEmpty()) {
	    		  user.setPassword(userModel.getPassword());
	    	  }
	    	  
	    	  if(!userModel.getPrenom().isEmpty()) {
	    		  user.setPrenom(userModel.getPrenom());
	    	  }
	    	    	
	    	  userMetier.ajouterUser(user);
	    	  return new ModelAndView("redirect:/user/listeUsers");
	    	  
	    	  
	      }
	      return null;
	}
	
	
	@RequestMapping(value="/ajouterUser",method=RequestMethod.GET)
	public String ajouterUser (Model model)
	{
        User user = new User();
		model.addAttribute("UserModel",user);
		return "ajouterUser";
		
		
	}
	

	@RequestMapping(value="/saveUser" , method=RequestMethod.POST)
	public String saveUser(Model model , @ModelAttribute UserModel userModel) {
        try { 
        	 if(userModel !=null) {
           	  User user = new User(userModel.getUsername(),userModel.getPassword(),userModel.getNom(),userModel.getPrenom(),userModel.getEmail());
              userMetier.ajouterUser(user);
              model.addAttribute("UserModel",userModel);
             
              return "redirect:/user/listeUsers";
        	 }
        	  
			
		} catch (Exception e) {
			// TODO: handle exception
		}            
	  
			    return "ajouterUser";
	}
	@RequestMapping(value="/listeUsers",method=RequestMethod.GET)
	public ModelAndView listeUsers(Model model) {
		 UserModel userModel = new UserModel();
		 userModel.setListeUsers(userMetier.consulterLesUsers());
		 return new ModelAndView("listeUsers","UserModel",userModel);
	}
	

	

}
