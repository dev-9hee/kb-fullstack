package org.example.dto;

// 회원 관리를 위한 DTO 클래스, 데이터 표현
public class MemberDto {
    private String id;
    private String name;

    public MemberDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
