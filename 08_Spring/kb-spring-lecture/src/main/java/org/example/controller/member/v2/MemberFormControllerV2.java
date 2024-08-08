package org.example.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class MemberFormControllerV2 {
    @GetMapping("/member/v2/form")
    public String home(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> 회원 추가 페이지 호출, /member/register");

        return "member-form2";
    }
}
