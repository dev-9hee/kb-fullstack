package org.example.controller.member;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/member/v3") // 중복되는 부분, 통합 처리, 요청 전체에 대한 매핑
public class MemberControllerV3 {
    private MemberDtoListV2 memberList;

    @Autowired // 빈 목록에서 이 데이터 타입인 애를 찾아서 넣어줌
    public MemberControllerV3(MemberDtoListV2 memberDtoList) {
        this.memberList = memberDtoList;
    }

    // /member/v3/show
    @GetMapping("/show")
    public String memberList(Model model) {
        log.info("========================> 회원 목록 조회 페이지 호출, /member/v3/show");

        model.addAttribute("memberList", memberList.getList());
        return "member-show3";
    }

    @GetMapping("/form")
    public String memberForm() {
        log.info("===============> 회원 추가 페이지 호출, /member/v3/form");
        return "member-form3";
    }

    @PostMapping(value = "/form/save")
    public String memberSave(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            Model model) {
        log.info("==========> 회원 추가 Request 호출, /member/v3/form/save");

        memberList.addList(id, name);

        model.addAttribute("memberList", memberList.getList());

        return "member-show3";
    }
}
