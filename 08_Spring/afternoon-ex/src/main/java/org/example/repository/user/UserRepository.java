package org.example.repository.user;

import lombok.RequiredArgsConstructor;
import org.example.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

// Data 와 통신하는 부분
@Repository
@Transactional // 쿼리문이 2개 이상 실행될 때 필요, 추가해주는게 좋음
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em; // 데이터 관련 처리 담당

    // 있는지 확인
    public User findByUsername(String username) {
        String jpql = "SELECT u FROM User u WHERE u.username = :username";

        List<User> users = em.createQuery(jpql, User.class)
                .setParameter("username", username)
                .getResultList(); // 결과를 리스트로 만들어서 알아서 넣어줌

        return users.isEmpty() ? null : users.get(0); // 리스트가 비었으면 null 을 리턴하여 해당 사용자가 없음을 표기
    }

    // 회원가입 기능
    public User save(User user) {
        em.persist(user);
        return user;
    }
}
