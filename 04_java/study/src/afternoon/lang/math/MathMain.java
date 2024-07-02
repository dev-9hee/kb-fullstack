package afternoon.lang.math;

public class MathMain {
    public static void main(String[] args) {
        // 기본 연산
        System.out.println(Math.max(10, 20)); // 최대
        System.out.println(Math.min(10, 20)); // 최소
        System.out.println(Math.abs(-10)); // 절대값

        // 소수점 연산
        System.out.println(Math.ceil(2.1)); // 올림
        System.out.println(Math.floor(2.1)); // 내림
        System.out.println(Math.round(2.1)); // 반올림

        // 기타
        System.out.println(Math.sqrt(4)); // 제곱근
        System.out.println(Math.random()); // 0 <= rand < 1
    }
}
