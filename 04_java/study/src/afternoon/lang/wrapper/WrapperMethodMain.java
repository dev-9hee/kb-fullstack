package afternoon.lang.wrapper;

public class WrapperMethodMain {
    public static void main(String[] args) {
        // 문자열을 기본 숫자 타입으로 변환
        int intValue = Integer.parseInt("10"); // 문자열을 원시 타입으로 변환
        System.out.println(intValue);

        // 비교
        Integer a = 10;
        System.out.println(a.compareTo(20)); // 20이랑 같은지 비교 , 같으면 1 리턴.. 다르면 -1 리턴

        // 산술 연산
        System.out.println(Integer.sum(10, 20));
        System.out.println(Integer.min(10, 20));
        System.out.println(Integer.max(10, 20));
    }
}
