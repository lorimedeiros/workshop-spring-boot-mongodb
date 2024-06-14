package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
//String pois é o tipo de dado que é o id do User



}
