package org.example.service.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.example.repository.user.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// 사용자의 비즈니스 로직을 처리
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder; // 암호화 도구 주입 받기

    // 사용자 username 을 통해 사용자를 찾음
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // DB에 있는 사용자의 비밀번호와 입력한 비밀번호가 일치하는지 확인
    public boolean isPasswordValid(User user, String rawPassword) {
        // 입력 받은 비밀번호를 암호화 한 다음 DB에 저장된 암호화 된 비밀번호와 비교하여 로그인 처리
        return passwordEncoder.matches(rawPassword, user.getPassword());
//        return rawPassword.equals(user.getPassword());
    }

    public User save(User user) {
        // 전달 받은 비밀번호를 암호화 도구를 사용하여 암호화 한 뒤, 저장하는 형태로 변경
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRoles("ROLE_MEMBER"); // 카카오로 뜨려면 코드 변경 필요!
        return userRepository.save(user);
    }
}
