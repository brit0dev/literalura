package br.com.alura.literalura.main;

import java.util.Scanner;

import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.service.BookService;

public class Main {
    private Scanner read = new Scanner(System.in);
    private BookService bookService;
    

    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookService = new BookService(bookRepository,authorRepository);
    }

    public void show_menu() {
        boolean loop = true;


        while (loop) {
            String menu = 
            """
            ----------- MENU -----------
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma

                0 - Sair
            """;
            System.out.println(menu);

            int option = read.nextInt();
            read.nextLine();

            System.out.println("----------- RESULTADO DA OPÇÃO -----------");

            switch (option) {
                case 1:
                    bookService.getBook();                
                    break;
                case 2:
                    bookService.listBooks();
                    break;
                case 3:
                    bookService.listAuthors();          
                    break;
                case 4:
                    System.out.println("Case 4");          
                    break;
                case 5:
                    System.out.println("Case 5");          
                    break;
                case 0:
                    System.out.println("Exiting...");
                    loop = false;
                    break;
                default:
                System.out.println("Opção inválida.");
                    break;
            }
        }

    }
}
