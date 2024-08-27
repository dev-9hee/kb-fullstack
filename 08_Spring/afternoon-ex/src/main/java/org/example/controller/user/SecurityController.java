package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.security.service.CustomUserDetailsService;
import org.example.service.user.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/security")
public class SecurityController {

    private final String context = "/security";
    private final UserService userService;
    private final CustomUserDetailsService customUserDetailsService;

    // 로그인 페이지
    @GetMapping("/login")
    public String loginPage() {
        return context + "/login";
    }

    // 로그인 실패 페이지
    @GetMapping("/login-failed")
    public String loginFailPage() {
        return context + "/login-failed";
    }

    // 스프링 시큐리티에 의해 로그인 된 사용자의 정보는 Principal 매개 변수를 통해 접근 가능
    @GetMapping("/member")
    public String memberPage(Model model, Principal principal) {
        if (principal == null) {
            return "redirect:/security/login";
        }

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return context + "/member";
    }

    // 권한이 있는 사람만 볼 수 있는 페이지
    @GetMapping("/admin")
    public String adminPage() {
        return context + "/admin";
    }
}
