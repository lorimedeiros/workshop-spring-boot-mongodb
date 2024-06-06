package com.lori.workshopmongo.resource;

import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.dto.UserDTO;
import com.lori.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    //o controlador acessa o serviço, o serviço, por sua vez, acessa o repository
    @Autowired
    private UserService service;

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

    @RequestMapping(method = RequestMethod.POST) //Ou @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO){
        User obj = service.fromDTO(objDTO);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //essa redação toda ai é pra pegar o endereço do novo objeto que for inserido
        return ResponseEntity.created(uri).build(); //esse created retorna o código 201 que é o código resposta http qiando criado um novo recurso
        //em outras palavras esse codigo vai retornar uma resposta vazia + cosigo 201 + localização do novo recurso criado
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id){
        User obj = service.fromDTO(objDTO);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.noContent().build();
    }

}
