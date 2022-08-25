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
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String addPost(@Validated @ModelAttribute("post") PostSaveForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws BindException {
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "views/post/add";
        }

        Post savedPost = postService.save(form);
        redirectAttributes.addAttribute("id", savedPost.getId());
//        redirectAttributes.addAttribute("status", true);
        return "redirect:{id}";
    }

    //수정
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postService.findById(id));
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute("post") PostUpdateForm form, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "views/post/edit";
        }

        postService.update(form);
        redirectAttributes.addAttribute("id", id);
//        redirectAttributes.addAttribute("status", true);
        return "redirect:/posts/{id}";
    }

    //삭제
    @GetMapping("/{id}/remove")
    public String removePost(@PathVariable long id) {
        postService.remove(id);
        return "redirect:/";
    }

    //답글
    @GetMapping("/{id}/reply")
    public String replyForm(@PathVariable long id, Model model) {
        model.addAttribute("post", new PostSaveForm());
        return "views/post/add";
    }
}



