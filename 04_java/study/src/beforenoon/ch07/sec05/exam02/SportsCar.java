package beforenoon.ch07.sec05.exam02;

public class SportsCar extends Car{ // 자식
    @Override
    public void speedUp() {
        speed += 10;
    }

    // 컴파일 에러, final 메서드는 오버라이딩을 할 수 없음
//    @Override
//    public void stop() {
//        System.out.println("스포츠카를 멈춤");
//        speed = 0;
//    }
}
