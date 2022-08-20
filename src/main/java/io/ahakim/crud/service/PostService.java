package io.ahakim.crud.service;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.dto.PostViewDto;
import io.ahakim.crud.errors.PostNotFoundException;
import io.ahakim.crud.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Boolean existsById(Long postId) {
        return postMapper.existsById(postId);
    }

    public List<Post> findAll(Criteria criteria) {
        return postMapper.selectAll(criteria);
    }

    @Transactional(readOnly = true)
    public PostViewDto findById(Long id) {
        Post post = postMapper.selectById(id)
                .orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시물"));

        return PostViewDto.builder()
                .id(post.getId())
                .writer(post.getWriter())
                .title(post.getTitle())
                .content(post.getContent())
                .views(post.getViews())
                .createdAt(post.getCreatedAt())
                .build();
    }

    //
    //    public Long save(Post post) {
    //        postMapper.insert(post);
    //        return post.getId();
    //    }
    //
    //    public void update(Post post) {
    //        postMapper.update(post);
    //    }
    //
    public void updateViews(Long id) {
        postMapper.updateViews(id);
    }
    //
    //    public void remove(Long id) {
    //        postMapper.delete(id);
    //    }
    //
    //    /* Reply */
    //    public Integer getNextStep(Long parentId) {
    //        return postMapper.selectNextStepByParentId(parentId);
    //    }
    //
    //    public void saveReply(Post post) {
    //        updateNextSteps(post.getRefId(), post.getParentId(), post.getStep());
    //        postMapper.insertReply(post);
    //    }
    //
    //    private void updateNextSteps(Long refId, Long parentId, Integer step) {
    //        postMapper.updateNextSteps(refId, parentId, step);
    //    }
}