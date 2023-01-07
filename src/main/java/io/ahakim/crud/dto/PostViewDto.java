package io.ahakim.crud.dto;

import io.ahakim.crud.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
public class PostViewDto {

    private Long id;

    @NotBlank
    @Size(max = 20)
    private String writer;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;

    private Integer views;

    private Integer level;

    private String createdAt;

    @Builder
    public PostViewDto(Long id, String writer, String title, String content, Integer views, Integer level, String createdAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.level = level;
        this.createdAt = createdAt;
    }

    @Builder
    public PostViewDto(Post post) {
        this.id = post.getId();
        this.writer = post.getWriter();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.views = post.getViews();
        this.level = post.getLevel();
        this.createdAt = post.getCreatedAt();
    }

    public Post toEntity() {
        return Post.builder()
                .id(id)
                .writer(writer)
                .title(title)
                .content(content)
                .views(views)
                .level(level)
                .createdAt(createdAt)
                .build();
    }
}