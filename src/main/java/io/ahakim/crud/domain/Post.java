package io.ahakim.crud.domain;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
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

    private Character status;

    @Builder
    public Post(Long id, String writer, String title, String content, Integer views, Long refId, Long parentId, Integer step, Integer level, String createdAt, Character status) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.refId = refId;
        this.parentId = parentId;
        this.step = step;
        this.level = level;
        this.createdAt = createdAt;
        this.status = status;
    }

    public Integer getNextLevel() {
        return this.level + 1;
    }
}


