package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Bean 등록
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
//        log.info("=================> HomeController /");
//        return "index"; // View 의 이름

        // 개발 편의를 위해 홈페이지를 임시로 게시판 목록 페이지로 리다이렉트
        return "redirect:/board/list";
    }
}
