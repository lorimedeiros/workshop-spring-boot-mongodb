package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
//String pois é o tipo de dado que é o id do User

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List <Post> searchTitle(String title);

    //sim, ambos os métodos são a msm coisa, só escolher (lá no PostService) qual usar dentro do método de busca

    List<Post> findByTitleContainingIgnoreCase(String text);

}
