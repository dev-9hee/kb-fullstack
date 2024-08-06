package org.example.dto.member;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// 실제 회원 정보를 담고 있는 List 클래스를 생성
@Component
public class MemberDtoListV2 {
    private List<MemberDto> memberDtoList;

    private MemberDtoListV2() {
        this.memberDtoList = new ArrayList<>(); // List 초기화
        // 테스트 데이터 추가
        this.addList("jihee", "정지희");
        this.addList("isu", "김이수");
    }

    public void addList(String id, String name) {
        memberDtoList.add(new MemberDto(id, name));
    }

    public List<MemberDto> getList() {
        return memberDtoList;
    }
}
