package operator;

// 문자열 더하기
public class Operator2 {
    public static void main(String[] args) {

        // 문자열과 문자열 더하기 1
        String result = "hello" + "world";
        System.out.println(result);

        // 문자열과 문자열 더하기 2
        String s1 = "string1";
        String s2 = "string2";
        String result2 = s1 + s2;
//        String result2 = s1.concat(s2); // 문자열 연결 함수
        System.out.println(result2);

        // 문자열과 숫자 더하기 1
        // 문자와 숫자를 더하면 숫자를 문자열로 변경한 다음에 서로 더한다.
        // 자바는 문자열인 String 타입에 다른 타입을 더하는 경우 대상 타입을 문자열로 변경
        String result3 = "a + b = " + 10; // 문자 + 숫자(문자로 바꿈) = 문자
        System.out.println(result3);

        // 문자열과 숫자 더하기 2
        int num = 20;
        String str = "a + b = ";
        String result4 = str + num; // 문자 + 숫자 = 문자
        System.out.println(result4);
    }
}
