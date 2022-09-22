package ru.buttonone.service;


import ru.buttonone.domain.Book;
import ru.buttonone.domain.Comment;

public interface CommentService {
    void leaveComment(Book book, String nickname, String message);
    void deleteComment(Comment comment);
    void saveComment(Comment comment);
    void deleteCommentByNickname(Book book, String nickname);
}
