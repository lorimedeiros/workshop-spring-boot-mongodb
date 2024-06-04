package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository <User, String> {
//String pois é o tipo de dado que é o id do User



}
