package com.lori.workshopmongo.repository;

import com.lori.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository <Post, String> {

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List <Post> searchTitle(String title);

    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, " + //vai verificar no campo date do post se essa data é maior igual($gte) a data min
            "{ date: {$lte: ?2} }, " + //vai verificar no campo date do post se essa data é menor igual($lte) a data max
            //aquele $and é um operador &&
            "{ $or: [ { 'title': { $regex: ?0, $options: 'i' } }, " + //verifica se o title contém o text
            "{ 'body': { $regex: ?0, $options: 'i' } }, " + //veriica se o body contem o text
            "{ 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }") //vai na lista comments, depois no atributo text do comment da lista para verificar se contém o text
            //aquele $or é um operador ||
    List<Post> fullSearch(String text, Date minDate, Date maxSate);
    //esse método vai procurar um post que contenha esse texto (em qualquer parte. Titulo, comentário ou corpo), entre um intervalo de datas

}
