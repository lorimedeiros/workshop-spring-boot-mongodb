package com.lori.workshopmongo.resources;

import com.lori.workshopmongo.domain.Post;
import com.lori.workshopmongo.resources.util.URL;
import com.lori.workshopmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //pode ver que esse nome titlesearch é o mesmo que usa no postman para buscas
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L)); //esse 0L é a menor data possível em sistemas java (sei lá quanto de 1960)
        Date max = URL.convertDate(maxDate, new Date()); //esse naew date sem nada cria uma data no instante atual, ou seja, o mais recente possível

        List<Post> list = service.fullSearch(text, min, max);
        return ResponseEntity.ok().body(list);
    }

}