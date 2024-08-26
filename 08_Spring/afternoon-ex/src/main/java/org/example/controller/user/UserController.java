package org.example.controller.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

// 사용자의 요청에 따른 화면 처리
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final String context = "/user";

    @GetMapping("/login")
    public String loginPage() {
        return context + "/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model, // 데이터 전송을 위한 Model
            HttpSession session) { // 로그인 정보 저장을 위한 Session

        User user = userService.findByUsername(username);

        if (user == null) {
            model.addAttribute("errMsg", "해당 ID의 사용자가 없습니다");
            return context + "/login-failed";
        }

        if (!userService.isPasswordValid(user, password)) {
            model.addAttribute("errMsg", "비밀번호가 틀립니다");
            return context + "/login-failed";
        }

        model.addAttribute("username", username);
        session.setAttribute("loginUser", user);

        return context + "/login-success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
//        session.removeAttribute("loginUser");
        session.invalidate(); // 세션 무효화, 만료
        return context + "/logout";
    }

    @GetMapping("/register")
    public String registerPage() {
        return context + "/register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model
    ) {
        if (username.isEmpty() || password.isEmpty()) {
            model.addAttribute("errMsg", "아이디 또는 비밀번호가 누락 되었습니다");
            return context + "/register-failed";
        }

        User user = userService.findByUsername(username);
        if (user != null) { // 동일한 아이디가 가진 회원이 있을 때
            model.addAttribute("errMsg", "동일한 ID를 가지는 사용자가 존재합니다");
            return context + "/register-failed";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userService.save(newUser);

        model.addAttribute("username", username);

        return context + "/register-success";
    }
}
