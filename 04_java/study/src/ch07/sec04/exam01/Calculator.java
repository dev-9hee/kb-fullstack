package ch07.sec04.exam01;

public class Calculator { // 부모
    // 메소드 선언
    public double areaCircle(double r) {
        System.out.println("Calculator 객체의 areaCircle() 실행");
        return 3.1459 * r * r; // return 값을 double형으로 받음
    }
}
