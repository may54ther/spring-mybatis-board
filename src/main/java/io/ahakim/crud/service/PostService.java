package io.ahakim.crud.service;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.dto.PostSaveDto;
import io.ahakim.crud.dto.PostViewDto;
import io.ahakim.crud.errors.PostNotFoundException;
import io.ahakim.crud.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /* Post */
    public int total() {
        return postMapper.total();
    }

    @Transactional(readOnly = true)
    public void existsById(Long id) {
        if (!postMapper.existsById(id))
            throw new PostNotFoundException("존재하지 않는 게시물입니다.");
    }

    @Transactional(readOnly = true)
    public List<PostViewDto> findAll(Criteria criteria) {
        return postMapper.selectAll(criteria)
                .stream()
                .map(PostViewDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PostViewDto findById(Long id) {
        Post post = postMapper.selectById(id)
                .orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시물입니다."));
        return PostViewDto.builder()
                .id(post.getId())
                .writer(post.getWriter())
                .title(post.getTitle())
                .content(post.getContent())
                .views(post.getViews())
                .createdAt(post.getCreatedAt())
                .build();
    }

    @Transactional
    public Long save(PostSaveDto postDto) {
        Post savePost = postDto.toEntity();
        postMapper.insert(savePost);
        return savePost.getId();
    }

    @Transactional
    public void update(Long id, PostSaveDto postDto) {
        Post updatePost = postDto.toEntity();
        updatePost.setId(id);
        postMapper.update(updatePost);
    }

    @Transactional
    public void updateViews(Long id) {
        postMapper.updateViews(id);
    }

    @Transactional
    public void remove(Long id) {
        existsById(id);
        postMapper.delete(id);
    }

    /* Reply */
    @Transactional(readOnly = true)
    public int getMaxStepByParentId(Long parentId) {
        return postMapper.selectMaxStepByParentId(parentId);
    }

    @Transactional
    public Long reply(Long parentId, PostSaveDto postDto) {
        Post parentPost = postMapper.selectById(parentId)
                .orElseThrow(() -> new PostNotFoundException("존재하지 않는 게시물입니다."));
        Post reply = Post.builder()
                .writer(postDto.getWriter())
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .parentId(parentId)
                .refId(parentPost.getRefId())
                .step(getMaxStepByParentId(parentId) + 1)
                .level(parentPost.getNextLevel())
                .build();

        updateSiblingSteps(reply.getRefId(), parentId, reply.getStep());
        postMapper.insertReply(reply);
        return reply.getId();
    }

    private void updateSiblingSteps(Long refId, Long parentId, Integer step) {
        postMapper.updateSiblingSteps(refId, parentId, step);
    }
}