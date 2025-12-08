package com.example.literalura;

import com.example.literalura.principal.Principal;
import com.example.literalura.service.LivroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    private final LivroService livroService;

    public LiteraluraApplication(LivroService livroService) {
        this.livroService = livroService;
    }

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) {
        new Principal(livroService).exibeMenu();
    }
}




