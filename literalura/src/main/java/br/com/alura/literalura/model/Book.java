package br.com.alura.literalura.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private List<String> languages;
    private int downloadCount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Author author;

    public Book() {
    }

    public Book(BookData book) {
        this.title = book.title();
        this.languages = book.languages();
        this.downloadCount = book.download_count();
        this.author = new Author(book.authors().get(0));
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {

        return                     
        """
        ----------- LIVRO -----------    
        Titulo: %s
        Autor: %s
        Idioma: %s
        Número de downloads: %s
        """.formatted(  this.title,
                        this.author.getName(), 
                        this.languages.get(0),
                        this.downloadCount
                    );
    }



}
