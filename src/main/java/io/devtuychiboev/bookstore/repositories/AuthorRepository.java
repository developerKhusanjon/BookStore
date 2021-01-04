package io.devtuychiboev.bookstore.repositories;

import io.devtuychiboev.bookstore.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
