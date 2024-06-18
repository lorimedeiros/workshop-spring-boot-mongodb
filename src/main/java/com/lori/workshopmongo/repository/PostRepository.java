package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {
//String pois é o tipo de dado que é o id do User

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }") //title(campo pelo qual queri efetur a busca), ?0(expressão regular; aquele primeiro parâmetro do método abaixo(title), se quisesse outro parâmetro ?1 ... ?n), i(options, esse i representa que vai ignorar maiuscula e minuscula)
    List <Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);
    //só essa declaração já faz com que o spring data monte a consulta

}
