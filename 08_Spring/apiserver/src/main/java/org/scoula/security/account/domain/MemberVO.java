package org.scoula.security.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String username;
    private String password;
    private String email;
    private Date regDate;
    private Date updateDate;

    private List<AuthVO> authList; // 권한 목록, join 처리 필요
}

// tbl_member 와 tbl_member_auth 를 join 처리
// MemberVO의 authList 를 설정
// MyBatis 의 resultMap 으로 Join 쿼리 결과를 MemberVO로 맵핑
