package org.example.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberShowControllerV2 {
    private MemberDtoListV2 memberList;

    @Autowired // 빈 목록에서 이 데이터 타입인 애를 찾아서 넣어줌
    public MemberShowControllerV2(MemberDtoListV2 memberDtoList) {
        this.memberList = memberDtoList;
    }

    @GetMapping("/member/v2/show")
    public String process(Model model) {
        log.info("========================> 회원 목록 조회 페이지 호출, /member/v2/show");

        model.addAttribute("memberList", memberList.getList());
        return "member-show2";
    }
}
