package io.devtuychiboev.bookstore.repositories;

import io.devtuychiboev.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
