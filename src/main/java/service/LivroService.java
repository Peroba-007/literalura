package com.example.literalura.service;

import com.example.literalura.model.DadosLivro;
import com.example.literalura.model.Livro;
import com.example.literalura.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public void salvarLivros(java.util.List<DadosLivro> dadosLivros) {

        int novos = 0;
        int duplicados = 0;

        for (DadosLivro dados : dadosLivros) {

            String titulo = dados.titulo();
            String autor = dados.autores().isEmpty()
                    ? "Desconhecido"
                    : dados.autores().get(0).name();

            // 🔎 verifica duplicidade
            boolean existe = repository
                    .findByTituloAndAutor(titulo, autor)
                    .isPresent();

            if (existe) {
                duplicados++;
                continue;
            }

            String idioma = dados.idiomas().isEmpty()
                    ? "desconhecido"
                    : dados.idiomas().get(0);

            Livro livro = new Livro(
                    titulo,
                    autor,
                    idioma,
                    dados.numeroDownloads()
            );

            repository.save(livro);
            novos++;
        }

        System.out.println("✅ Livros novos salvos: " + novos);
        if (duplicados > 0) {
            System.out.println("⚠ Livros ignorados (duplicados): " + duplicados);
        }
    }

    public java.util.List<Livro> listarTodos() {
        return repository.findAll();
    }

    public java.util.List<Livro> listarPorIdioma(String idioma) {
        return repository.findByIdiomaIgnoreCase(idioma);
    }
}







