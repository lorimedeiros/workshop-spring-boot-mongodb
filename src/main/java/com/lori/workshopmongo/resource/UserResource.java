package com.lori.workshopmongo.resource;

import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //o controlador acessa o serviço, o serviço, por sua vez, acessa o repository
    @Autowired
    private UserServices service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List <User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
