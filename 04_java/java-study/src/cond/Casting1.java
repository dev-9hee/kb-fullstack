package cond;

public class Casting1 {

    public static void main(String[] args) {
        int intValue = 10;
        long longValue;
        double doubleValue;

        // 큰 그릇은 작은 그릇에 담긴 내용물을 담을 수 있음
        // 작은 범위 숫자 타입에서 큰 범위 숫자 타입으로의 대입 => 자동 형변환
        longValue = intValue; // int -> long
        System.out.println("longValue = " + longValue);

        doubleValue = intValue; // int -> double
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; // long -> double
        System.out.println("doubleValue = " + doubleValue);


    }
}
