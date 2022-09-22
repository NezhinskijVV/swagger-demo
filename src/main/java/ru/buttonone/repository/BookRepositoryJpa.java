package ru.buttonone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.buttonone.domain.Book;

import java.util.List;

public interface BookRepositoryJpa extends JpaRepository<Book, Long> {
    List<Book> getAllByTitle(String title);
}