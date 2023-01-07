package io.ahakim.crud.controller;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.PageMaker;
import io.ahakim.crud.dto.PostSaveDto;
import io.ahakim.crud.dto.PostViewDto;
import io.ahakim.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    // TODO. @Validated 또는 @Valid 사용해서 검증 찾기
    // TODO. posts() -> 페이지 처리 공통화 (Resolver)

    private final PostService postService;

    @GetMapping
    public String posts(@ModelAttribute Criteria criteria, Model model, RedirectAttributes redirect) {
        int total = postService.total();
        int totalPage = (int) Math.ceil((double) total / criteria.getSize());
        int page = criteria.getPage();
        if (page < 1 || page > totalPage) {
            redirect.addFlashAttribute("criteria", criteria);
            return "redirect:";
        }

        PageMaker pageMaker = new PageMaker(total, criteria);
        List<PostViewDto> posts = postService.findAll(pageMaker.getCriteria());
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("posts", posts);
        return "views/post/list";
    }

    @GetMapping("/{id}")
    public String post(@PathVariable Long id, Model model) {
        PostViewDto post = postService.findById(id);
        postService.updateViews(id);
        model.addAttribute("postForm", post);
        return "views/post/detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("postForm", new PostSaveDto());
        return "views/post/add";
    }

    @PostMapping("/add")
    public String addPost(PostSaveDto postForm, RedirectAttributes redirect) {
        //        if (bindingResult.hasErrors()) {
        //            log.info("errors={}", bindingResult);
        //            return "views/post/edit";
        //        }
        redirect.addAttribute("id", postService.save(postForm));
        return "redirect:{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        postService.existsById(id);
        model.addAttribute("postForm", postService.findById(id));
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable Long id, PostSaveDto postForm, RedirectAttributes redirect) {
        //        if (bindingResult.hasErrors()) {
        //            log.info("errors={}", bindingResult);
        //            return "views/post/edit";
        //        }
        postService.update(id, postForm);
        redirect.addAttribute("id", id);
        return "redirect:/posts/{id}";
    }

    @GetMapping("/{id}/remove")
    public String removePost(@PathVariable long id) {
        postService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{parentId}/reply")
    public String replyForm(@PathVariable Long parentId, Model model) {
        postService.existsById(parentId);
        model.addAttribute("postForm", new PostSaveDto());
        return "views/post/add";
    }

    @PostMapping("/{parentId}/reply")
    public String addReply(@PathVariable Long parentId, PostSaveDto postForm, RedirectAttributes redirect) {
        redirect.addAttribute("id", postService.reply(parentId, postForm));
        return "redirect:/posts/{id}";
    }
}

