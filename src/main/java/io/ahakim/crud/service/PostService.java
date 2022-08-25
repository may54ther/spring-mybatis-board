package io.ahakim.crud.service;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.form.PostSaveForm;
import io.ahakim.crud.form.PostUpdateForm;
import io.ahakim.crud.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    public Boolean existsById(Long postId) {
        return postMapper.existsById(postId);
    }

    public int total() {
        return postMapper.total();
    }

    public List<Post> findAll(Criteria criteria) {
        return postMapper.selectAll(criteria);
    }

    public Post findById(Long id) {
        return postMapper.selectById(id);
    }

    public Post save(PostSaveForm form) {
        Post post = new Post();
        post.setWriter(form.getWriter());
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());

        postMapper.insert(post);
        return post;
    }

    public void update(PostUpdateForm form) {
        postMapper.update(form);
    }

    public void updateViews(Long id) {
        postMapper.updateViews(id);
    }

    public void remove(Long id) {
        postMapper.delete(id);
    }
}