package br.com.alura.literalura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.literalura.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Author findByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM authors WHERE birth_year<=:year AND death_year>=:year")
    public List<Author> listAuthorsAlive(int year);
}
