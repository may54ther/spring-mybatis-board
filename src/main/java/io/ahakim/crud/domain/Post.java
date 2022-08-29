package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private Integer views;
    private Long refId;
    private Long parentId;
    private Integer step;
    private Integer level;
    private String createdAt;
    private Character flag;

    public Post(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}


