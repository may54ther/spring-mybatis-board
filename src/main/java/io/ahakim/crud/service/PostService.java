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

    public Long save(Post post) {
        postMapper.insert(post);
        return post.getId();
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

    /* Reply */
    public Integer getNextStep(Long parentId) {
        return postMapper.selectNextStepByParentId(parentId);
    }

    public void saveReply(Post post) {
        updateNextSteps(post.getRefId(), post.getParentId(), post.getStep());
        postMapper.insertReply(post);
    }

    private void updateNextSteps(Long refId, Long parentId, Integer step) {
        postMapper.updateNextSteps(refId, parentId, step);
    }
}