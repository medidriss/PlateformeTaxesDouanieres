package com.enit.controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
import com.enit.models.PaysOrigineModel;

import com.enit.models.SimulationModel;
import com.enit.models.UserModel;

@Controller
@RequestMapping(value="/home",method= {RequestMethod.GET,RequestMethod.POST})

public class HomeController {



	
	
	
	
}
