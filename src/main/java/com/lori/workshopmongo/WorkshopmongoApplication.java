package com.lori.workshopmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongoApplication.class, args);
	}

	/*
	https://www.mongodb.com/docs/manual/reference/operator/query/regex/
	site com as informações acerca do método @querry, aquele no PostRepository, tem a sintaze e mais options(como o i)

	para fazer pesquisa no postman:
	http://localhost:8080/posts/titlesearch?text=dia
	só trocar "dia" por qualquer palavra que queira buscar
	*/

}
