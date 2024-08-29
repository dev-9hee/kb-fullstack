package org.scoula.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // Bean 등록
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("=================> HomeController /");
        return "index"; // View 의 이름
    }
}
