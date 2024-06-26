package cond;

// 단순히 참과 거짓에 따라서 특정 값을 구하는 경우 삼항 연산자 또는 조건 연산자라고 불리는 ?: 연산자를 사용
public class CondOp2 {

    public static void main(String[] args) {
        int age = 18;
        String status = (age >= 18) ? "성인" : "미성년자"; // 참이면 성인, 거짓이면 미성년자
        System.out.println("age = " + age + " status = " + status);
    }
}
