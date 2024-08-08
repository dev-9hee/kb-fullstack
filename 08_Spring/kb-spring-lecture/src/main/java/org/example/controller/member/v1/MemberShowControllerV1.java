package org.example.controller.member.v1;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class MemberShowControllerV1 {
    private MemberDtoListV1 memberList = MemberDtoListV1.getInstance();

    @GetMapping("/member/show")
    public String process(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> 회원 조회 페이지 호출, /member/show");

        request.setAttribute("memberList", memberList.getList());
        return "member-show";
    }
}
