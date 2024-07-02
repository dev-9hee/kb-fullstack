package afternoon.lang.wrapper;

public class CompareMain {
    public static void main(String[] args) {
//        int a = 1;
//        int b = 2;

        // 원시형 데이터를 마치 객체처럼 사용
        Integer a = Integer.valueOf(1); // 초기값은 valueOf()로 설정
        Integer b = Integer.valueOf(2);

        // 원시형 데이터 타입은 객체가 아니기 때문에 자체적으로 메서드를 가질 수 없음 => 이럴 때 Wrapper 객체 사용
//        a.compareTo(b);

        // 이제 a는 객체이므로 compareTo()와 같은 내장 클래스 활용 가능
        System.out.println(a.compareTo(b)); // a < b => -1 반환
        // compareTo(b) 메서드는 다음과 같은 규칙을 따름
        // 만약 this 객체가 b 객체보다 작으면, 음수를 반환합니다.
        // 만약 this 객체가 b 객체와 같으면, 0을 반환합니다.
        // 만약 this 객체가 b 객체보다 크면, 양수를 반환합니다.
    }
}
