package afternoon.poly3.casting1;

public class CastingMain1 {
    public static void main(String[] args) {
        Child child = new Child();

        Parent parent1 = child; // 부모는 자식을 담을 수 있다.
        Parent perent2 = (Parent) child; // 안 보이지만 생략된 부분, 업캐스팅이 숨겨져 있음
    }
}
