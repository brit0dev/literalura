package br.com.alura.literalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.literalura.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    public Author findByName(String name);

}
