package org.example.dto.member;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// 실제 회원 정보를 담고 있는 List 클래스를 생성
// 마이바티스를 이용하여 DB 로부터 데이터를 불러오는 클래스
@Repository // @Component 랑 기능은 비슷, 저장소라는 의미
//@RequiredArgsConstructor // 생성자 만들어주고, autowired 까지
public class MemberRepository {
    private MemberMapper memberMapper;

    @Autowired
    public MemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<MemberDto> findAll() {
        return memberMapper.findAll(); // xml 파일을 읽어서 구현됨
    }
}
