package operator;

// 전위, 후위 증감 연산자
public class OperatorAdd2 {

    public static void main(String[] args) {
        // 전위 증감 연산자 사용 예
        int a = 1;
        int b = 0;

        b = ++a; // a의 값을 먼저 증가시키고, 그 결과를 b에 대입

//        a = a + 1; //a의 증감 연산이 먼저 진행, a = 2
//        b = a; //이후에 a를 대입 b = 2

        System.out.println("a = " + a + ", b = " + b); // a = 2, b = 2

        // 후위 증감 연산자
        a = 1; // a 값을 다시 1로 지정
        b = 0; // b 값을 다시 0으로 지정

        b = a++; // a의 현재 값을 b에 먼저 대입하고, 그 후 a 값을 증가시킴

//        b = a; //a의 값을 먼저 b에 대입 b = 1
//        a = a + 1; //이후에 a의 값을 증가 a = 2

        System.out.println("a = " + a + ", b = " + b); // a = 2, b = 1
    }
}
