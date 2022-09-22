package ru.buttonone.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.buttonone.domain.Comment;

@Data
@AllArgsConstructor
public class CommentDto {
    private final String id;
    private final String bookId;
    private final String nickname;
    private final String message;

    public static Comment toDomainObject(CommentDto dto) {
        return Comment.builder()
                .bookId(Long.parseLong(dto.bookId))
                .nickname(dto.nickname)
                .message(dto.message).build();
    }

    public static CommentDto toDto(Comment comment) {
        return new CommentDto(String.valueOf(comment.getId()), String.valueOf(comment.getBookId()),
                comment.getNickname(), comment.getMessage());
    }
}
