package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.dto.post.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> findAll();

    // 검색
    List<PostDto>findByCondition(
            @Param("title") String title,
            @Param("content") String content
    );

    // 삭제, id를 기준으로 삭제, 매개변수 이름 지정
    int postDelete(@Param("id") Long id);

    // 게시글 추가
    int postSave(@Param("title") String title, @Param("content") String content);
}
