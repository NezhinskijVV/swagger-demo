package ru.buttonone.service;


import ru.buttonone.domain.Book;

import java.util.List;

public interface BookService {
    Book getBookByTitle(String title);

    Book getBookById(long id);

    List<Book> getAllBooks();
    void takeBookById(long id);
    void takeBookByTitle(String title);
    void takeAllBooks();

    void saveBook(Book book);
}