package com.lori.workshopmongo.resource;

import com.lori.workshopmongo.domain.Post;
import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.dto.UserDTO;
import com.lori.workshopmongo.services.PostService;
import com.lori.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    //o controlador acessa o serviço, o serviço, por sua vez, acessa o repository
    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    //esse codigo basicamente cria aquele caminho posts/valorDeUmId
    public ResponseEntity<Post> findById(@PathVariable String id) { //esse @ é para indicar que esse valor é aquele {id} ali em cima
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}