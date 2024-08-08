package org.example.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
@RequestMapping("/member/v3")
public class MemberControllerV3 {
    private final MemberDtoListV2 memberDtoList;

    @Autowired
    public MemberControllerV3(MemberDtoListV2 memberDtoList) {
        this.memberDtoList = memberDtoList;
    }

    @GetMapping("/show")
    public String memberList(Model model) {
        log.info("================> 회원 조회 페이지 호출, /member/list");

        model.addAttribute("memberList", memberDtoList.getList());
        return "member-show3";
    }

    @GetMapping("/form")
    public String memberForm(HttpServletRequest request, HttpServletResponse response) {
        log.info("================> 회원 추가 페이지 호출, /member/register");

        return "member-form3";
    }

    @PostMapping("/form/save")
    public String memberSave(@RequestParam("id") String id, @RequestParam("name") String name, Model model) {
        log.info("================> 회원 추가 Request 호출, /member/form3/save2");

        memberDtoList.addList(id, name);
        model.addAttribute("memberList", memberDtoList.getList());
        return "member-show3";
    }
}
