package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
//String pois é o tipo de dado que é o id do User

    List<Post> findByTitleContainingIgnoreCase(String text);
    //só essa declaração já faz com que o spring data monte a consulta

}
