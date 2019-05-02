package com.enit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.enit.entites.Nomenclature;
import com.enit.entites.Taxe;

public interface TaxeRepository extends MongoRepository<Taxe,String> {

}
