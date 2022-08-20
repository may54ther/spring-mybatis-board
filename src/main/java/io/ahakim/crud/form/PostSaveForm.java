package io.ahakim.crud.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveForm {

    @NotBlank
    @Size(max = 20)
    private String writer;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;
}