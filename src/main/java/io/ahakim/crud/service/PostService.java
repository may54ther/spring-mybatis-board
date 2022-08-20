package io.ahakim.crud.service;

import io.ahakim.crud.domain.Post;
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


    public int total() {
        return postMapper.total();
    }

    public List<Post> findAll() {
        return postMapper.selectAll(0, 10);
    }

    public Post findById(Long id) {
        return postMapper.selectById(id);
    }

    public Post save(Post post) {
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