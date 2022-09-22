package ru.buttonone.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.buttonone.rest.dto.CommentDto;
import ru.buttonone.domain.Book;
import ru.buttonone.service.BookService;
import ru.buttonone.service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final BookService bookService;

    @GetMapping("api/books/{id}/comments")
    public List<CommentDto> getAllComments(@PathVariable("id") long bookId) {
        Book book = bookService
                .getBookById(bookId);
        return book.getComments().stream()
                .map(CommentDto::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("api/books/{id}/comments")
    public ResponseEntity<CommentDto> createBook(@RequestBody CommentDto commentDto, @PathVariable String id) {
        commentService.saveComment(CommentDto.toDomainObject(commentDto));
        return ResponseEntity.ok(commentDto);
    }
}