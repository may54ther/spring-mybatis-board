package io.ahakim.crud.controller;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.PageMaker;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.form.PostSaveForm;
import io.ahakim.crud.form.PostUpdateForm;
import io.ahakim.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String posts(@ModelAttribute Criteria criteria, Model model) {
        PageMaker pageMaker = new PageMaker(postService.total(), criteria);
        model.addAttribute("posts", postService.findAll(criteria));
        model.addAttribute("pageMaker", pageMaker);
        return "views/post/list";
    }

    //조회
    @GetMapping("/{id}")
    public String post(@PathVariable long id, Model model) {
        postService.updateViews(id);
        model.addAttribute("post", postService.findById(id));
        return "views/post/detail";
    }

    //등록
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("post", new PostSaveForm());
        return "views/post/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute PostSaveForm form, RedirectAttributes redirectAttributes) {
        Post post = new Post();
        post.setWriter(form.getWriter());
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());

        Post savedPost = postService.save(post);
        redirectAttributes.addAttribute("id", savedPost.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:{id}";
    }

    //수정
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute PostUpdateForm form, RedirectAttributes redirectAttributes) {
        postService.update(form);
        redirectAttributes.addAttribute("id", id);
        redirectAttributes.addAttribute("status", true);
        return "redirect:/posts/{id}";
    }

    //삭제
    @GetMapping("/{id}/remove")
    public String remove(@PathVariable long id) {
        postService.remove(id);
        return "redirect:/";
    }
}