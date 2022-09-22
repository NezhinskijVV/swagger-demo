package ru.buttonone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "b_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_id", nullable = false)
    private long bookId;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "message", nullable = false)
    private String message;
}