package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*TODO Note: La clase CommandLineRunner es una clase que durante el lifecycle de spring este va a buscar para
*  ejecutar el método run*/
@Component // TODO: Ponemos component para que se cree la bean
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Designios De Dioses", "ekdfvjn123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rad = new Author("Rod", "Johnson");
        Book noejb = new Book("J2EE Develoment bla bla", "2139084");

        rad.getBooks().add(noejb);
        noejb.getAuthors().add(rad);

        authorRepository.save(rad);
        bookRepository.save(noejb);

        Publisher publisher = new Publisher("Lestrade", "Calle san pedro", "Ciudad Real", "Castilla y Leon", "34542");

        publisherRepository.save(publisher);

        System.out.println("Started Bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());
        System.out.println("Number of Authors: "+ authorRepository.count());
        System.out.println("Number of Publishers: "+ publisherRepository.count());


    }
}
