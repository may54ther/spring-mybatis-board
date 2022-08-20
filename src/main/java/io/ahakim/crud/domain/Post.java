package io.ahakim.crud.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Post {

    private Long id;
    private String writer;
    private String title;
    private String content;
    private Integer views;
    private Long refId;
    private Integer order;
    private Integer indent;
    private LocalDateTime createdAt;
    private Character flag;
}


