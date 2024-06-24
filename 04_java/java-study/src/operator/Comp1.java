package operator;

// 비교 연산자
// 비교 연산자를 사용하면 참( true ) 또는 거짓( false )이라는 결과가 나온다. 참 거짓은 boolean 형을 사용한다
public class Comp1 {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;

        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a > b); // false
        System.out.println(a < b); // true
        System.out.println(a >= b); // false
        System.out.println(a <= b); // true

        System.out.println();
        // 결과를 boolean 변수에 담음
        boolean result = a == b;
        System.out.println(result); // false
    }
}
