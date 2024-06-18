package com.lori.workshopmongo.services;

import com.lori.workshopmongo.domain.Post;
import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.dto.UserDTO;
import com.lori.workshopmongo.repository.PostRepository;
import com.lori.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        //vai ser feita uma gambiarra para arredondar a data máxima em um dia, isso pq as datas são armazenadas de 00:00, ou seja, pode dar ruim
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //pq essa conta toda? pq a data é armazenada em milissegundos
        return repo.fullSearch(text, minDate, maxDate);
    }

}
