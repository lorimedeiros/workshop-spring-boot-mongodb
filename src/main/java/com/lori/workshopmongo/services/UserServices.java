package com.lori.workshopmongo.services;

import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.repository.UserRepository;
import com.lori.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }

}
