package org.example.repository.book.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.domain.BookMybatis;

import java.util.List;

@Mapper
public interface BookMapper {
    public List<BookMybatis> findAll(); // 정체 목록 조회
    public BookMybatis findById(@Param("id") Long id); // 특정 id 조회
    public int save(BookMybatis newBook); // 새로운 책 저장
    public int delete(@Param("id") Long id); // 기존 책 삭제
}
