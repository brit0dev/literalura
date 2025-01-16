package br.com.alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
