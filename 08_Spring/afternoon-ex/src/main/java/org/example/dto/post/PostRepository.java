package org.example.dto.post;

import lombok.RequiredArgsConstructor;
import org.example.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    private final PostMapper postMapper;

    public List<PostDto> findAll() {
        return postMapper.findAll();
    }

    public List<PostDto> findByCondition(String title, String content) {
        return postMapper.findByCondition(title, content);
    }

    public int postDelete(Long id) {
        return postMapper.postDelete(id);
    }

    public int postSave(String title, String content) {
        return postMapper.postSave(title, content);
    }
}
