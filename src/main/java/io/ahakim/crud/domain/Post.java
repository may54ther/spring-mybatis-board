package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String writer;
    private String password;
    private String title;
    private String content;
    private Integer views;
    private Long refId;
    private Integer order;
    private Integer indent;
    private LocalDateTime createdAt;
    private LocalDateTime deletedAt;
    private Character flag;

    public Post(Long id, String password) {
        this.id = id;
        this.title = password;
    }

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}


