package ru.buttonone.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.buttonone.domain.Author;
import ru.buttonone.repository.AuthorRepositoryJpa;


import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositoryJpa authorRepositoryJpa;

    @Transactional(readOnly = true)
    @Override
    public Optional<Author> getByFio(String fio) {
        try {
            return authorRepositoryJpa.getByFio(fio);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }
}
