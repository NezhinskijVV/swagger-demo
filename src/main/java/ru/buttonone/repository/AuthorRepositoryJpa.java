package ru.buttonone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buttonone.domain.Author;

import java.util.Optional;

public interface AuthorRepositoryJpa extends JpaRepository<Author, Long> {
    Optional<Author> getByFio(String fio);
}