package ru.buttonone.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.buttonone.domain.Author;
import ru.buttonone.domain.Book;
import ru.buttonone.domain.Genre;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private String authors;
    private String genre;

    public static Book toDomainObject(BookDto dto) {
        System.out.println("toDomainObject" + dto);
        List<Author> authors = Arrays.stream(dto.getAuthors().split(","))
                .map(Author::new)
                .collect(Collectors.toList());

        return Book.builder()
                .title(dto.title)
                .authors(authors)
                .genre(new Genre(dto.getGenre())).build();
    }

    public static BookDto toDto(Book book) {
        String authors = book.getAuthors()
                .stream().map(Author::getFio)
                .collect(Collectors.joining(","));
        String genre = book.getGenre().getName();
        return new BookDto(String.valueOf(book.getId()), book.getTitle(), authors, genre);
    }
}