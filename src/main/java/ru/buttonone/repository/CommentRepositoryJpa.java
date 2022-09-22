package ru.buttonone.repository;

import org.springframework.data.repository.CrudRepository;
import ru.buttonone.domain.Comment;


public interface CommentRepositoryJpa extends CrudRepository<Comment, Long> {
    void deleteAllByBookId(long bookId);
}