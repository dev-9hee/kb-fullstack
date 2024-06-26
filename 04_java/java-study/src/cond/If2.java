package cond;

public class If2 {
    public static void main(String[] args) {
        int age = 20;

        // 특정 조건이 만족하면 해당 코드를 실행하고 if 문 전체를 빠져나옴
        if (age >= 18) { // true
            System.out.println("성인입니다."); // 출력됨
        } else { // 그렇지 않으면
            System.out.println("미성년자입니다.");
        }
    }
}
