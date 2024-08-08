package org.example.controller.member.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.member.MemberDtoListV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class MemberSaveControllerV2 {
    // 싱글톤 객체를 받아옴
    private MemberDtoListV2 memberList;

    @Autowired // 빈 목록에서 이 데이터 타입인 애를 찾아서 넣어줌
    public MemberSaveControllerV2(MemberDtoListV2 memberDtoList) {
        this.memberList = memberDtoList;
    }

    // 요청 전체에 대한 매핑
    @RequestMapping(value = "/member/v2/form/save", method = RequestMethod.GET)
    public String process(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            Model model) {
        log.info("==========> 회원 추가 Request 호출, /member/v2/form/save");

        memberList.addList(id, name);

        model.addAttribute("memberList", memberList.getList());

        return "member-show2";
    }


}
