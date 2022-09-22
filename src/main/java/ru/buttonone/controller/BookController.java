package ru.buttonone.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.buttonone.rest.dto.BookDto;
import ru.buttonone.service.BookService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping("/api/books")
    public List<BookDto> getALL() {
        return bookService.getAllBooks()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/api/books/{id}")
    public BookDto editPage(@PathVariable("id") long id) {
        return BookDto.toDto(bookService.getBookById(id));
    }

    @PostMapping("/api/books/{id}")
    public String editBook(BookDto bookDto) {
        bookService.saveBook(BookDto.toDomainObject(bookDto));
        return "redirect:/";
    }

    @PutMapping("/api/books/{id}")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(BookDto.toDomainObject(bookDto));
        return ResponseEntity.ok(bookDto);
    }

    @DeleteMapping("/api/books/{id}")
    public String deletePage(@PathVariable("id") long id) {
        bookService.takeBookById(id);
        return "redirect:/";
    }

    @PostMapping("/api/books/add")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        bookService.saveBook(BookDto.toDomainObject(bookDto));
        System.out.println(bookService.getAllBooks());
        return ResponseEntity.ok(bookDto);
    }
}