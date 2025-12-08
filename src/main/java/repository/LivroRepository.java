package com.example.literalura.repository;

import com.example.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByIdiomaIgnoreCase(String idioma);

    Optional<Livro> findByTituloAndAutor(String titulo, String autor);
}


