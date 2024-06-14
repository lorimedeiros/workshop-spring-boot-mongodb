package com.lori.workshopmongo.config;

import com.lori.workshopmongo.domain.Post;
import com.lori.workshopmongo.domain.User;
import com.lori.workshopmongo.dto.AuthorDTO;
import com.lori.workshopmongo.repository.PostRepository;
import com.lori.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll(); //isso aqui é necessário pois, como brinquei antes com o mongodb, já tem dados lá
        postRepository.deleteAll();

        User lori = new User(null, "Lori Medeiros", "lori@leromail.com");
        User yves = new User(null, "Yves Pereira", "yves@leromail.com");
        User pedro = new User(null, "Pedro Henrique", "pedenrique@leromail.com");
        User sonysta = new User(null, "Leandro Franklin", "sonysta@leromail.com");

        userRepository.saveAll(Arrays.asList(lori, yves, pedro, sonysta));
        //detalhe que é preciso salvar primeiro os usuários para que eles tenham um id, se eu colocar essa linha la em baixo os ids ficarão nulos na referencia ao obj

        Post pst1 = new Post(null, sdf.parse("12/06/2024"), "Feliz dia dos namorados!", "Feliz dia dos namorados, estou muito feliz com minha namorada.\n*foto do ps5*", new AuthorDTO(sonysta));
        Post pst2 = new Post(null, sdf.parse("12/06/2024"), "Como assim não comemoram dia dos solteiros!?", "Achei uma injustiça sem tamanho, solteiros também merecem um dia.", new AuthorDTO(lori));
        Post pst3 = new Post(null, sdf.parse("12/06/2024"), "Algo especial hoje?", "Nem sabia que hoje era uma data comemorativa, estava jogando genshin e me deparei com uma choradeira imensa no grupo.\n(Isso não foi uma indireta para Lori)", new AuthorDTO(pedro));

        postRepository.saveAll(Arrays.asList(pst1, pst2, pst3));

        sonysta.getPosts().add(pst1);
        lori.getPosts().add(pst2);
        pedro.getPosts().add(pst3);

        userRepository.saveAll(Arrays.asList(sonysta, lori, pedro));

    }
}
