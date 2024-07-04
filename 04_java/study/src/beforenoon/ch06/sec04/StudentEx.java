package beforenoon.ch06.sec04;

public class StudentEx {
    public static void main(String[] args) { // 실행 클래스 : main() 메소드를 가지고 있는 실행 가능한 클래스
        Student s1 = new Student(); // 클래스 변수 = new 클래스();, new 연산자는 객체를 생성시키고 객체의 주소를 리턴
        System.out.println("s1 변수가 Student 객체를 참조합니다.");

        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다.");
    }
}
