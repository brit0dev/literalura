package br.com.alura.literalura.service;


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
                                    
            for (BookData bookData : searchResult.results()) {
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
            }

        } else {
            System.out.println("O livro '" + bookTitle + "' não foi encontrado.");
        }
    }

}
