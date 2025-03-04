package br.com.alura.literalura.service;

import java.util.List;
import java.util.Scanner;

import br.com.alura.literalura.model.Author;
import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.model.BookData;
import br.com.alura.literalura.model.SearchData;
import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;

public class BookService {
    APIConsume apiConsume = new APIConsume();
    DataConverter converter = new DataConverter();
    Scanner read = new Scanner(System.in);
    BookRepository bookRepository = null;
    AuthorRepository authorRepository = null;


    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

    }

    public void getBook(){
        System.out.println("Digite o nome do livro: ");
        String bookTitle = read.nextLine();

        String json = apiConsume.getData(bookTitle.toLowerCase().replace(" ", "+"));
        SearchData searchResult = converter.getData(SearchData.class, json);
    
        if (searchResult.count() >= 1) {           
                BookData bookData = searchResult.results().get(0);
                Book book = new Book(bookData);
                Author searchedAuthor = authorRepository.findByName(bookData.authors().get(0).name());
                
                if(searchedAuthor != null){
                    book.setAuthor(searchedAuthor);
                    searchedAuthor.addBook(book);
                } else {
                    Author author = new Author(bookData.authors().get(0));
                    authorRepository.save(author);

                    book.setAuthor(author);
                }
                
                System.out.println(book);
                bookRepository.save(book);


        } else {
            System.out.println("O livro '" + bookTitle + "' não foi encontrado.");
        }
    }

    public void listBooks(){
        bookRepository.findAll().forEach(System.out::println);
    }

    public void listAuthors(){
        authorRepository.findAll().forEach(System.out::println);
    }

    public void listAuthorsAlive(){
        System.out.println("Digite um ano para busca: ");
        int year = read.nextInt();

        authorRepository.listAuthorsAlive(year).forEach(System.out::println);
    }

    public void listBooksByLanguage(){
        System.out.println(
            """
                Insira o idioma para realizar a busca:
                es- espanhol
                en- inglês
                fr- francês
                pt- português
            """
            );
        String language = read.nextLine();

        //System.out.println("'"+language+"'");
        //System.out.println(bookRepository.listBooksByLanguage(language));
        bookRepository.findAllByLanguagesIn(List.of(language)).forEach(System.out::println);;
    }
}
