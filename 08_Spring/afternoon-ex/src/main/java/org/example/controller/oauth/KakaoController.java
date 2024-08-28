package org.example.controller.oauth;

import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.service.oauth.KakaoOauthService;
import org.example.service.user.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kakao")
public class KakaoController {
    private final KakaoOauthService kakaoLoginService;
    private final UserService userService;

    @GetMapping("/login")
    public String kakaoLogin(@RequestParam("code") String code) {
        String accessToken = kakaoLoginService.getAccessToken(code);
        JsonObject userInfo = kakaoLoginService.getUserInfo(accessToken);

        if (userInfo != null) {
            String kakaoId = userInfo.get("id").getAsString();
            String nickname = userInfo.get("nickname").getAsString();

            if (userService.findByUsername(nickname) == null) {
                User kakaoUser = new User();
                kakaoUser.setUsername(nickname);
                kakaoUser.setPassword("kakao");
                kakaoUser.setRoles("ROLE_KAKAO");
                userService.save(kakaoUser);
            }

            // Authentication 객체 생성
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    nickname, null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_KAKAO")));

            // SecurityContext에 Authentication 객체를 저장
            SecurityContextHolder.getContext().setAuthentication(authentication);

            return "redirect:/security/member";
        } else {
            // 에러 처리
            return "redirect:/security/login-failed";
        }
    }
}
