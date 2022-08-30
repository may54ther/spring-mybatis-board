package io.ahakim.crud.controller;

import io.ahakim.crud.controller.form.PostForm;
import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.PageMaker;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    //목록
    @GetMapping
    public String posts(@ModelAttribute Criteria criteria, Model model, RedirectAttributes redirect) {
        int total = postService.total();
        int totalPage = (int) Math.ceil((double) total / criteria.getRowSize());
        int page = criteria.getPage();
        if (page < 1 || page > totalPage) {
            redirect.addFlashAttribute("criteria", criteria);
            return "redirect:";
        }

        PageMaker pageMaker = new PageMaker(postService.total(), criteria);
        List<Post> posts = postService.findAll(pageMaker.getCriteria());
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("posts", posts);
        return "views/post/list";
    }

    //조회
    @GetMapping("/{id}")
    public String post(@PathVariable long id, Model model, RedirectAttributes redirect) {
        if (!postService.existsById(id)) {
            redirect.addFlashAttribute("msg", "존재하지 않는 게시물입니다.");
            return "redirect:/posts";
        }
        postService.updateViews(id);
        model.addAttribute("postForm", postService.findById(id));
        return "views/post/detail";
    }

    //등록
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "views/post/add";
    }

    @PostMapping("/add")
    public String addPost(PostForm form, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            log.info("errors={}", result);
            return "views/post/add";
        }

        Post post = new Post(form.getId(), form.getWriter(), form.getTitle(), form.getContent());
        postService.save(post);

        redirect.addAttribute("id", post.getId());
        return "redirect:{id}";
    }

    //수정
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {

        model.addAttribute("postForm", postService.findById(id));
        return "views/post/edit";
    }

    @PostMapping("/{id}/edit")
    public String editPost(@PathVariable long id, PostForm form, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            log.info("errors={}", result);
            return "views/post/edit";
        }

        Post post = new Post(form.getId(), form.getWriter(), form.getTitle(), form.getContent());
        postService.update(post);

        redirect.addAttribute("id", id);
        return "redirect:/posts/{id}";
    }

    //삭제
    @GetMapping("/{id}/remove")
    public String removePost(@PathVariable long id) {
        postService.remove(id);
        return "redirect:/";
    }

    //답글
    @GetMapping("/{parentId}/reply")
    public String replyForm(@PathVariable long parentId, Model model) {
        model.addAttribute("postForm", new PostForm());
        return "views/post/add";
    }

    @PostMapping("/{parentId}/reply")
    public String addReply(@PathVariable long parentId, PostForm form, Model model) {
        Post parentPost = postService.findById(parentId);
        int nextStep = postService.getNextStep(parentId);

        Post post = new Post(form.getWriter(), form.getTitle(), form.getContent());
        post.setRefId(parentPost.getRefId());
        post.setParentId(parentPost.getId());
        post.setStep(nextStep);
        post.setLevel(parentPost.getNextLevel());

        postService.saveReply(post);
        return "redirect:/posts";
    }
}

