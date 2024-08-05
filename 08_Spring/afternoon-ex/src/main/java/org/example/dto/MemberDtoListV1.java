package org.example.dto;

import java.util.ArrayList;
import java.util.List;

// 실제 회원 정보를 담고 있는 List 클래스를 생성
public class MemberDtoListV1 {
    private static MemberDtoListV1 instance;
    private List<MemberDto> memberDtoList;

    private MemberDtoListV1() {
        this.memberDtoList = new ArrayList<>(); // List 초기화
        // 테스트 데이터 추가
        this.addList("jihee", "정지희");
        this.addList("isu", "김이수");
    }

    // synchronized, 한 번에 한 스레드만 접근하게 해 줌, 데이터 보호
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
