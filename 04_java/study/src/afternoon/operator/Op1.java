package afternoon.operator;

public class Op1 {
    public static void main(String[] args) {
        // 산술 연산의 특이점
//        int a = 3;
//        int b = 2;
//        System.out.println(a/b); // 정수/정수 = 정수

        // 문자 연산의 특이점 1
        String str = "a + b = ";
        int c = 10;
        System.out.println(str + 10); // 문자열 + 숫자 => 숫자를 문자로 형변환 시켜줌

        // 문자 연산의 특이점 2
        int d = 10;
        char e = 'e'; // 아스키코드 e(101)
        System.out.println(d + e); // 101 + 10 = 111
    }
}
