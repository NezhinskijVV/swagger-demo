package ru.buttonone.service;


import ru.buttonone.domain.Genre;

import java.util.Optional;

public interface GenreService {
    Optional<Genre> getByName(String name);
}
