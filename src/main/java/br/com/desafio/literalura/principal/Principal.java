package br.com.desafio.literalura.principal;

import br.com.desafio.literalura.model.Autor;
import br.com.desafio.literalura.model.Language;
import br.com.desafio.literalura.model.Livro;
import br.com.desafio.literalura.repository.AutorRepository;
import br.com.desafio.literalura.repository.LivroRepository;
import br.com.desafio.literalura.service.GetLivro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
@Service
public class Principal {
    Scanner leitura = new Scanner(System.in);
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> authors = new ArrayList<>();
    private final String URL = "https://gutendex.com/books/?search=";
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    String menuOpcoes = """
            ------------------------------------------------------
            |         *** Busca de Livros ***                    |   
            |                                                    |       
            |    1 - Buscar livro pelo título                    |   
            |    2 - Filtrar livros registrados                  |   
            |    3 - Filtrar autores registrados                 |   
            |    4 - Filtrar autores vivos em um determinado ano |   
            |    5 - Filtrar livros em determinado idioma        |   
            |    6 - Filtrar Top 20 livros mais baixados         |   
            |    7 - Buscar autor do Livro                       |   
            |                                                    |   
            |    0 - Sair das Opcoes                             |
            ------------------------------------------------------   
            """;



    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {

            System.out.println(menuOpcoes);
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao) {
                case 1:
                    buscarLivros();
                    break;
                case 2:
                    filtrarLivros();
                    break;
                case 3:
                    filtrarAutores();
                    break;
                case 4:
                    filtrarAutoresVivosAno();
                    break;
                case 5:
                    filtrarLivrosIdioma();
                    break;
                case 6:
                    filtrarTop10Livros();
                    break;
                case 7:
                    filtrarAutor();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void buscarLivros() {
        System.out.println("Deseja o nome do livro que deseja pesquisar: ");
        String url = URL + leitura.nextLine().toLowerCase().replace(" ", "%20");
        GetLivro getter = new GetLivro(livroRepository, autorRepository);
        getter.getDataBook(url);
    }


    private void filtrarLivros() {
        livros = livroRepository.findAll();
        livros.stream().forEach(System.out::println);
    }

    private void filtrarAutores() {
        authors = autorRepository.findAll();
        authors.stream().forEach(System.out::println);
    }

    private void filtrarAutoresVivosAno() {
        authors = autorRepository.findAll();
        System.out.println("Digite o ano para verificar os autores vivos:");
        int year = leitura.nextInt();
        leitura.nextLine();
        autorRepository.findLivingAuthorsInYear(year).stream().forEach(System.out::println);
    }

    private void filtrarLivrosIdioma() {
        System.out.println("Digite o idioma desejado:");
        String idioma = leitura.nextLine().toLowerCase();
        Language lang = Language.fromIdioma(idioma);

        List<Livro> allLivros = livroRepository.findAll();

        List<Livro> livrosIdioma = livroRepository.findBooksByLanguage(lang);
        System.out.println("Livros disponíveis no idioma " + idioma);
        livrosIdioma.forEach(System.out::println);
    }

    private void filtrarTop10Livros() {
        GetLivro getter = new GetLivro(livroRepository, autorRepository);
        getter.getTop(URL);
    }

    private void filtrarAutor() {
        System.out.println("Digite o nome ou sobrenome do autor que deseja buscar informações: ");
        String autor = leitura.nextLine().replace(" ", "%20");
        GetLivro getter = new GetLivro(livroRepository, autorRepository);
        getter.getAuthor(autor);
    }

}
