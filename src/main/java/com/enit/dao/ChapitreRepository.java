package com.enit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.enit.entites.Chapitre;

public interface ChapitreRepository extends MongoRepository<Chapitre,String> {

}
