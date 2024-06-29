package afternoon.poly4;

public class StopHeeMain {
    public static void main(String[] args) {
        // 인터페이스는 실체화가 안 됨
        Dog dog = new Dog();
        StopHee stopHee = new StopHee();

        animalDo(dog);
        animalDo(stopHee);
        System.out.println();
        humanDo(stopHee);
    }

    public static void animalDo(Animal animal) {
        System.out.println("동물 기능 테스트");
        animal.eat();
        animal.sleep();
        System.out.println("동물 기능 테스트 종료");
    }

    public static void humanDo(Human human) {
        System.out.println("사람 기능 테스트");
        human.think();
        System.out.println("사람 기능 테스트 종료");
    }
}
