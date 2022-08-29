package io.ahakim.crud.mapper;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    /* Post */
    int total();
    Boolean existsById(Long id);
    List<Post> selectAll(Criteria criteria);
    Post selectById(Long id);
    void insert(Post post);
    void update(Post post);
    void updateViews(Long id);
    void delete(Long id);
    /* Reply */
    Integer selectNextStepByParentId(Long parentId);
    void insertReply(Post post);
    void updateNextSteps(Long refId, Long parentId, Integer step);
}

