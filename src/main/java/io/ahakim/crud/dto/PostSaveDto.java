package io.ahakim.crud.dto;

import io.ahakim.crud.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
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


    @Builder
    public PostSaveDto(String writer, String title, String content, Long parentId) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.parentId = parentId;
    }

    public Post toEntity() {
        return Post.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .parentId(parentId)
                .build();
    }
}