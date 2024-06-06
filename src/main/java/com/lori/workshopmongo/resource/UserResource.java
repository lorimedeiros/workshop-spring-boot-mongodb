package com.lori.workshopmongo.resource;

import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.dto.UserDTO;
import com.lori.workshopmongo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //o controlador acessa o serviço, o serviço, por sua vez, acessa o repository
    @Autowired
    private UserServices service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List <User> list = service.findAll();
        List <UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList()); //essa linha aqui converte cada item da lista original para item da lista DTO
        return ResponseEntity.ok().body(listDTO);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET) //esse codigo basicamente cria aquele caminho users/valorDeUmId
    public ResponseEntity<UserDTO> findById(@PathVariable String id){ //esse @ é para indicar que esse valor é aquele {id} ali em cima
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }

}
