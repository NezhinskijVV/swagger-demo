package ru.buttonone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.buttonone.domain.Genre;

import java.util.Optional;

@Repository
public interface GenreRepositoryJpa extends JpaRepository<Genre, Long> {
    Optional<Genre> getByName(String name);
}
