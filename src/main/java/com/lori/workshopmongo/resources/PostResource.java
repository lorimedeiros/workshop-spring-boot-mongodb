package com.lori.workshopmongo.resources;

import com.lori.workshopmongo.domain.Post;
import com.lori.workshopmongo.resources.util.URL;
import com.lori.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    //esse codigo basicamente cria aquele caminho posts/valorDeUmId
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

}