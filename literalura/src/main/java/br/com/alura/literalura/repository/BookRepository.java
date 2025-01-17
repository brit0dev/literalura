package br.com.alura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.literalura.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByLanguagesIn(List<String> languages);

    @Query(value = "SELECT * FROM books WHERE languages IN ('{?1}')", nativeQuery = true) 
    public List<Book> listBooksByLanguage(String language);
    
}
