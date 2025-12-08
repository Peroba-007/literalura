package com.example.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1000) // ✅ evita erro de título longo
    private String titulo;

    private String autor;
    private String idioma;
    private Integer downloads;

    // ✅ construtor padrão obrigatório para JPA
    public Livro() {
    }

    public Livro(String titulo, String autor, String idioma, Integer downloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.downloads = downloads;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }
}


