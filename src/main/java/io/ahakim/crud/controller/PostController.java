package io.ahakim.crud.controller;

import io.ahakim.crud.form.PostSaveForm;
import io.ahakim.crud.form.PostUpdateForm;
import io.ahakim.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String posts(Model model) {
        return "views/post/list";
    }

    //조회
    @GetMapping("/{id}")
    public String post(@PathVariable long id, Model model) {
        return "views/post/detail";
    }

    //등록
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("post", new PostSaveForm());
        return "views/post/add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute PostSaveForm form) {
        return "redirect:{id}";
    }

    //수정
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", new PostUpdateForm());
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable long id) {
        return "redirect:{id}";
    }

    //삭제
    @GetMapping("/{id}/remove")
    public String remove(@PathVariable long id) {
        return "redirect:/";
    }
}