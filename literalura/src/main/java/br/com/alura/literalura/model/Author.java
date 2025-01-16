package br.com.alura.literalura.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int birth_year;
    private int death_year;

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(AuthorData author) {
        this.name = author.name();
        this.birth_year = author.birth_year();
        this.death_year = author.death_year();
    }


    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + ", birth_year=" + birth_year + ", death_year=" + death_year
                + ", books=" + books + "]";
    }

    public void addBook(Book book){
        books.add(book);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }

    public List<Book> getBooks(){
        return this.books;
    }
}
