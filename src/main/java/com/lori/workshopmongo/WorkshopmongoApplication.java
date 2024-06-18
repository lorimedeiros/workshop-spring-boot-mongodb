package com.lori.workshopmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkshopmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopmongoApplication.class, args);
	}

	/*
	http://localhost:8080/posts/fullsearch?text=especial&maxDate=2024-06-15
	só dale isso no postman que ele vai retornar um post do pedroca
	*/

}
