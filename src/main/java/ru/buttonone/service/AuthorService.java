package ru.buttonone.service;


import ru.buttonone.domain.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> getByFio(String fio);
}
