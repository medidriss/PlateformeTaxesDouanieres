package com.enit.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.enit.entites.Nomenclature;
import com.enit.entites.Simulation;
import com.enit.entites.User;

public interface SimulationRepository extends MongoRepository<Simulation,String> {
   public Simulation findSimulationByNomSimulation(String nomSimulation);
   public List<Simulation> findSimulationByUser(User user);
}
