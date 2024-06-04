package com.lori.workshopmongo.resource;

import com.lori.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        User lori = new User("1", "Lori Medeiros", "lori@leromail.com");
        User yves = new User("2", "Yves Pereira", "yves@leromail.com");
        User pedroca = new User("3", "Pedro Henrique", "pedenrique@leromail.com");

        return ResponseEntity.ok().body(Arrays.asList(lori, yves, pedroca));

    }
}
