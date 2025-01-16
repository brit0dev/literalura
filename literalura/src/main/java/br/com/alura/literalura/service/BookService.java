package br.com.alura.literalura.service;


import java.util.Scanner;

import br.com.alura.literalura.repository.BookRepository;

public class BookService {
    APIConsume apiConsume = new APIConsume();
    DataConverter converter = new DataConverter();
    Scanner read = new Scanner(System.in);
    BookRepository bookRepository = null;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

}
