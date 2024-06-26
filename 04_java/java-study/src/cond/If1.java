package cond;

public class If1 {
    public static void main(String[] args) {
        int age = 20; // 사용자 나이

        if (age >= 18) { // true
            System.out.println("성인입니다."); // 출력됨
        }

        if (age < 18) { // false, 코드블럭 실행 안 함
            System.out.println("미성년자입니다.");
        } // 조건이 거짓이므로 if 문 블록을 실행하지 않고, 빠져나온다!
    }
}
