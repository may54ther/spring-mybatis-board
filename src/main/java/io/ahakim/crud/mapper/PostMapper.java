package io.ahakim.crud.mapper;

import io.ahakim.crud.domain.Criteria;
import io.ahakim.crud.domain.Post;
import io.ahakim.crud.form.PostUpdateForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    int total();
    Boolean existsById(Long id);
    List<Post> selectAll(Criteria criteria);
    Post selectById(Long id);
    void insert(Post post);
    void update(PostUpdateForm form);
    void updateViews(Long id);
    void delete(Long id);
}

