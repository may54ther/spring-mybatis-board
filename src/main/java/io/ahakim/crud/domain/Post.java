package io.ahakim.crud.domain;

import lombok.*;


@Setter
@Getter
@ToString
@NoArgsConstructor
public class Post {

    private Long id;

    private String userId;

    private String writer;

    private String title;

    private String content;

    private Integer views;

    private Long refId;

    private Long parentId;

    private Integer step;

    private Integer level;

    private Character status;

    private String createdAt;

    @Builder
    public Post(Long id, String userId, String writer, String title, String content, Integer views, Long refId, Long parentId, Integer step, Integer level, Character status, String createdAt) {
        this.id = id;
        this.userId = userId;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.refId = refId;
        this.parentId = parentId;
        this.step = step;
        this.level = level;
        this.status = status;
        this.createdAt = createdAt;
    }

    //
    //    @Builder
    //    public PostViewDto toDto() {
    //        return PostViewDto.builder()
    //                .id(id)
    //                .writer(writer)
    //                .title(title)
    //                .content(content)
    //                .views(views)
    //                .createdAt(createdAt)
    //                .build();
    //
    //    }

    public Integer getNextLevel() {
        return this.level + 1;
    }
}


