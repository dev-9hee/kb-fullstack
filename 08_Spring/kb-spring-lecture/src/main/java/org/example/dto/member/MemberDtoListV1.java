package org.example.dto.member;

import java.util.ArrayList;
import java.util.List;

public class MemberDtoListV1 {
    private static MemberDtoListV1 instance;
    private List<MemberDto> memberDtoList;

    private MemberDtoListV1() {
        this.memberDtoList = new ArrayList<>(); // List 초기화
        // 테스트 데이터 추가
        this.addList("tetz", "이효석");
        this.addList("siwan", "김시완");
    }

    // 싱글톤 인스턴스 반환 메소드
    public static synchronized MemberDtoListV1 getInstance() {
        if (instance == null) {
            instance = new MemberDtoListV1();
        }
        return instance;
    }

    public void addList(String id, String name) {
        memberDtoList.add(new MemberDto(id, name));
    }

    public List<MemberDto> getList() {
        return memberDtoList;
    }
}
