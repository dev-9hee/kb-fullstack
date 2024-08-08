package org.example.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class MemberSaveControllerV2 {
    private final MemberDtoListV2 memberList;

    @Autowired
    public MemberSaveControllerV2(MemberDtoListV2 memberList) {
        this.memberList = memberList;
    }

    @GetMapping("/member/v2/form/save")
    public String process(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            Model model
    ) {
        log.info("================> 회원 추가 Request 호출, /member/form/save");

        memberList.addList(id, name);

        model.addAttribute("memberList", memberList.getList());
        return "member-show2";
    }
}
