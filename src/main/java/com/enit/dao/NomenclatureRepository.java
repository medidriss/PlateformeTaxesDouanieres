package com.enit.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enit.entites.Nomenclature;

public interface NomenclatureRepository extends MongoRepository<Nomenclature,String> {
	@Query("{ 'designation' : ?0 }")
	public List<Nomenclature> findNomenclatureByDesignation( @Param(value="mc") String mc);

}
