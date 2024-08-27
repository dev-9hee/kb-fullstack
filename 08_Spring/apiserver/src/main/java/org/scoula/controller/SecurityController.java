package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {

    @GetMapping("/all") // 모두 접근 가능
    public void doAll() {
        log.info("do all can access everybody");
    }

    @GetMapping("/member") // member 또는 admin 권한 필요
    public void doMember() {
        log.info("logined member");
    }

    @GetMapping("/admin") // admin 권한 필요
    public void doAdmin() {
        log.info("admin only");
    }

    @GetMapping("/login") // 로그인 페이지
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}
