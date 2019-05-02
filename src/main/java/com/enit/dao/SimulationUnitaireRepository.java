package com.enit.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enit.entites.Simulation;
import com.enit.entites.SimulationUnitaire;
import com.enit.entites.SimulationUnitaireKey;

public interface SimulationUnitaireRepository extends MongoRepository<SimulationUnitaire,SimulationUnitaireKey> {
	@Query("{ 'id.idSimulation' : ?0 }")
	public Page<SimulationUnitaire> FindSimulationUnitaireBySimulation( @Param(value="idSimulation") String idSimulation,Pageable pageable);
    
	@Query("{ 'id.idSimulation' : ?0 }")
	public List<SimulationUnitaire> FindSimulationUnitaireBySimulation( @Param(value="idSimulation") String idSimulation);

}
