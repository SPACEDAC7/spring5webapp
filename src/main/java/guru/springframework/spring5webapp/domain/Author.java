package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.Set;


@Entity  // Definimos un objeto dentro de JPA
public class Author {

    @Id //Definimos primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //El id se va a general automaticamente por la db
    private Long id;

    private String firstName;
    private String lastName;
    // NOote: Un autor tiene muchos libros

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public Author() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
