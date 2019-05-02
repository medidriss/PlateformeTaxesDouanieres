package com.enit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.enit.entites.Nomenclature;
import com.enit.entites.User;

public interface UserRepository extends MongoRepository<User,String> {
   public User findUserByUsername(String username);
}
