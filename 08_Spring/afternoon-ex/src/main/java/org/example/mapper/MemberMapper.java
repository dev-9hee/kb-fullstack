package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.member.MemberDto;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<MemberDto> findAll(); // 실제 구현은 MyBatis 가 채워줌
}
