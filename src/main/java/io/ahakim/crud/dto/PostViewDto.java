package io.ahakim.crud.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Builder
public class PostViewDto {

    private long id;

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
    public PostViewDto(long id, String writer, String title, String content, Integer views, Integer level, String createdAt) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.views = views;
        this.level = level;
        this.createdAt = createdAt;
    }
}