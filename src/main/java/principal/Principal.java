package com.example.literalura.principal;

import com.example.literalura.model.DadosResposta;
import com.example.literalura.service.ConsumoApi;
import com.example.literalura.service.ConverteDados;
import com.example.literalura.service.LivroService;

import java.util.Scanner;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final ConsumoApi consumoApi = new ConsumoApi();
    private final ConverteDados conversor = new ConverteDados();
    private final LivroService livroService;

    private static final String ENDERECO = "https://gutendex.com/books/?search=";

    public Principal(LivroService livroService) {
        this.livroService = livroService;
    }

    public void exibeMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    
                    ===== MENU LITERALURA =====
                    1 - Buscar livro por título (API)
                    2 - Listar livros salvos
                    3 - Listar livros por idioma
                    0 - Sair
                    ===========================
                    Escolha uma opção:
                    """);

            String entrada = leitura.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("\n❌ Entrada inválida. Digite apenas números.");
                continue;
            }

            switch (opcao) {
                case 1 -> buscarLivroPorTitulo();
                case 2 -> listarLivrosSalvos();
                case 3 -> listarLivrosPorIdioma();
                case 0 -> System.out.println("Encerrando o programa. Até mais!");
                default -> System.out.println("❌ Opção inválida.");
            }
        }
    }

    private void buscarLivroPorTitulo() {
        System.out.println("Digite o título:");
        String titulo = leitura.nextLine();

        String json = consumoApi.obterDados(
                ENDERECO + titulo.replace(" ", "+")
        );

        DadosResposta dados = conversor.obterDados(json, DadosResposta.class);

        if (dados == null || dados.resultados().isEmpty()) {
            System.out.println("❌ Livro não encontrado.");
            return;
        }

        livroService.salvarLivros(dados.resultados());
    }

    private void listarLivrosSalvos() {
        var livros = livroService.listarTodos();

        if (livros.isEmpty()) {
            System.out.println("⚠ Nenhum livro salvo.");
            return;
        }

        livros.forEach(l -> {
            System.out.println("""
                    -------------------------
                    Título: %s
                    Autor: %s
                    Idioma: %s
                    Downloads: %d
                    """.formatted(
                    l.getTitulo(),
                    l.getAutor(),
                    l.getIdioma(),
                    l.getDownloads()
            ));
        });
    }

    private void listarLivrosPorIdioma() {
        System.out.println("Digite o idioma (pt, en, es, fr):");
        String idioma = leitura.nextLine().toLowerCase();

        var livros = livroService.listarPorIdioma(idioma);

        if (livros.isEmpty()) {
            System.out.println("⚠ Nenhum livro encontrado nesse idioma.");
            return;
        }

        livros.forEach(l ->
                System.out.println(l.getTitulo() + " - " + l.getAutor())
        );
    }
}
















