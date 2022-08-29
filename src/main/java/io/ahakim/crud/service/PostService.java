package io.ahakim.crud.service;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
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

    /* Post */
    public int total() {
        return postMapper.total();
    }

    private Boolean existsById(Long postId) {
        return postMapper.existsById(postId);
    }

    public List<Post> findAll(Criteria criteria) {
        return postMapper.selectAll(criteria);
    }

    public Post findById(Long id) {
        return postMapper.selectById(id);
    }

    public void save(Post post) {
        postMapper.insert(post);
    }

    public void update(Post post) {
        postMapper.update(post);
    }

    public void updateViews(Long id) {
        postMapper.updateViews(id);
    }

    public void remove(Long id) {
        postMapper.delete(id);
    }
}