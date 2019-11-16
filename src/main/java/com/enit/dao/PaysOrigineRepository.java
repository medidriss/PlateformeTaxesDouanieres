package com.enit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.enit.entites.Nomenclature;
import com.enit.entites.PaysOrigine;

public interface PaysOrigineRepository extends MongoRepository<PaysOrigine, String> {

}
