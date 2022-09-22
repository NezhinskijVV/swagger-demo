package ru.buttonone.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.buttonone.domain.Author;
import ru.buttonone.domain.Book;
import ru.buttonone.exception.BookNotFoundException;
import ru.buttonone.repository.BookRepositoryJpa;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepositoryJpa bookRepositoryJpa;
    private final GenreService genreService;
    private final AuthorService authorService;

    @Transactional(readOnly = true)
    @Override
    public Book getBookByTitle(String title) {
        return bookRepositoryJpa.getAllByTitle(title).stream().findFirst()
                .orElseThrow(() -> {
                    throw new BookNotFoundException();
                });
    }

    @Override
    public Book getBookById(long id) {
        return bookRepositoryJpa.findById(id)
                .orElseThrow(() -> {
                    throw new BookNotFoundException();
                });
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getAllBooks() {
        return bookRepositoryJpa.findAll();
    }

    @Transactional
    @Override
    public void takeBookById(long id) {
        bookRepositoryJpa.findById(id)
                .ifPresent(book -> bookRepositoryJpa.deleteById(book.getId()));
    }

    @Transactional
    @Override
    public void takeBookByTitle(String title) {
        bookRepositoryJpa.getAllByTitle(title).stream().findAny()
                .ifPresent(book -> bookRepositoryJpa.deleteById(book.getId()));
    }

    @Transactional
    @Override
    public void takeAllBooks() {
        for (Book book : bookRepositoryJpa.findAll()) {
            long id = book.getId();
            bookRepositoryJpa.deleteById(id);
        }
    }

    @Transactional
    @Override
    public void saveBook(Book book) {
        Optional<Book> optionalBook = bookRepositoryJpa.findById(book.getId());
        if (optionalBook.isEmpty()) {
            genreService.getByName(book.getGenre().getName())
                    .ifPresent(book::setGenre);

            final List<Author> authors = book.getAuthors();
            List<Author> resAuthors = new ArrayList<>();

            authors.forEach(author -> authorService.getByFio(author.getFio())
                    .ifPresentOrElse(resAuthors::add,
                            () -> resAuthors.add(author)));
            book.setAuthors(resAuthors);

            if (book.getComments() == null){
                book.setComments(new ArrayList<>());
            }
        } else {
            book.setComments(optionalBook.get().getComments());
        }
        bookRepositoryJpa.save(book);
    }
}