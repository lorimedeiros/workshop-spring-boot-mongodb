package com.lori.workshopmongo.config;

import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll(); //isso aqui é necessário pois, como brinquei antes com o mongodb, já tem dados lá

        User lori = new User(null, "Lori Medeiros", "lori@leromail.com");
        User yves = new User(null, "Yves Pereira", "yves@leromail.com");
        User pedro = new User(null, "Pedro Henrique", "pedenrique@leromail.com");
        User sonysta = new User(null, "Leandro Franklin", "sonysta@leromail.com");

        userRepository.saveAll(Arrays.asList(lori, yves, pedro, sonysta));

    }

}
