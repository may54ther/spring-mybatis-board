package io.ahakim.crud.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Builder
@NoArgsConstructor
public class PostSaveDto {

    @NotBlank
    @Size(max = 20)
    private String writer;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;

    private Long parentId;

    private String createdAt;

    @Builder
    public PostSaveDto(String writer, String title, String content, Long parentId, String createdAt) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
        this.createdAt = createdAt;
    }
}