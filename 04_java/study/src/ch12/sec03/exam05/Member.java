package ch12.sec03.exam05;

import lombok.*;

// 롬복 라이브러리 사용
// 생성된 코드 확인 : Alt + 7 or Structure 아이콘
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴의 코드를 자동으로 만들어줌
public class Member {
    private String id;
    @NonNull // 필수 항목 -> @RequiredArgsConstructor 에 의해 생성자 추가됨
    private String name;
    private int age;
}
