package cond;

public class If3 {
    public static void main(String[] args) {
        int age = 14;

        // 불필요한 조건 검사, 이미 조건을 만족해도 불필요한 다음 조건을 계속 검사, 조건을 중복 체크한 것
        // else if 를 사용하면 불필요한 조건 검사를 피하고 코드의 효율성을 향상
        if (age <= 7) { // ~7: 미취학
            System.out.println("미취학");
        }
        if(age >= 8 && age <= 13) { // 8~13: 초등학생
            System.out.println("초등학생");
        }
        if(age >= 14 && age <= 16) { // 14~16: 중학생
            System.out.println("중학생");
        }
        if(age >= 17 && age <= 19) { // 17~19: 고등학생
            System.out.println("고등학생");
        }
        if(age >= 20) { // 20~: 성인
            System.out.println("성인");
        }
    }
}
