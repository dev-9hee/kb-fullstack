package ch07.sec04.exam01;

public class Computer extends Calculator{ // 자식
    // 메소드 오버라이딩 : 상속된 메소드를 자식 클래스에서 재정의하는 것
    // 해당 부모 메소드는 숨겨지고, 자식 메소드가 우선적으로 사용
    @Override // Ctrl + O / 컴파일 시 정확히 오버라이딩이 되었는지 체크 해줌
    public double areaCircle(double r) {
        System.out.println("Computer 객체의 areaCircle() 실행");
        return Math.PI * r * r;
    }
}
