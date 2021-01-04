package io.devtuychiboev.bookstore.bootstrap;

import io.devtuychiboev.bookstore.domain.Author;
import io.devtuychiboev.bookstore.domain.Book;
import io.devtuychiboev.bookstore.repositories.AuthorRepository;
import io.devtuychiboev.bookstore.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author husanboy = new Author("Khusanjon","Developer");
        Author hasanjon = new Author("Khasanjon","Engineer");

        Book python_in_use = new Book("Python in Use","123456");
        Book java_in_use = new Book("Java in Use","12345");

        hasanjon.getBooks().add(java_in_use);
        hasanjon.getBooks().add(python_in_use);
        husanboy.getBooks().add(java_in_use);
        husanboy.getBooks().add(python_in_use);

        java_in_use.getAuthors().add(husanboy);
        java_in_use.getAuthors().add(hasanjon);
        python_in_use.getAuthors().add(hasanjon);
        python_in_use.getAuthors().add(husanboy);

        authorRepository.saveAll(Arrays.asList(hasanjon,husanboy));
        bookRepository.saveAll(Arrays.asList(java_in_use,python_in_use));

        System.out.println("Running on commandLine...");
        System.out.println("quantity of books is "+ bookRepository.count());

    }
}
