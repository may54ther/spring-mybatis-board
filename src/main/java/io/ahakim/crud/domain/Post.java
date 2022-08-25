package io.ahakim.crud.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private Integer views;
    private Long refId;
    private Integer step;
    private Integer level;
    private String createdAt;
    private Character flag;

    public Post(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Post(Long id, String writer, String title, String content, Integer views, Long refId, Integer step, Integer level) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.refId = refId;
        this.step = step;
        this.level = level;
    }
}


