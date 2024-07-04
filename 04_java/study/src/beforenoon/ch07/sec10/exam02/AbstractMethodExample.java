package beforenoon.ch07.sec10.exam02;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound(); // 멍멍

        Cat cat = new Cat();
        cat.sound(); // 야옹

        // 매개변수의 다형성
        animalSound(new Dog()); // 멍멍
        animalSound(new Cat()); // 야옹
    }
    public static void animalSound(Animal animal) { // 자동 타입 변환 일어남
        animal.sound(); // 재정의된 메소드 호출
    }
}
