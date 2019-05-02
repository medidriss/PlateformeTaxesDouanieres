package com.enit;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.enit.dao.NomenclatureRepository;
import com.enit.dao.NomenclaturesTaxesRepository;
import com.enit.entites.Chapitre;
import com.enit.entites.Nomenclature;
import com.enit.entites.Role;
import com.enit.entites.Simulation;
import com.enit.entites.User;
import com.enit.metiers.ChapitreMetier;
import com.enit.metiers.NomenclatureMetier;
import com.enit.metiers.NomenclaturesTaxesMetier;
import com.enit.metiers.SimulationMetier;
import com.enit.metiers.UserMetier;

@SpringBootApplication
public class MongoDbSpringDemoApplication implements CommandLineRunner {
	 


   public static void main(String[] args) {
		SpringApplication.run(MongoDbSpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
      
      
      
	}

}
 


