package afternoon.poly2;

public class AnimalMain {
    public static void main(String[] args) {
        Donkey donkey = new Donkey();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Chicken chicken = new Chicken();

        // 부모는 자식 클래스를 담을 수 있으므로 각각 자식 인스턴스를 전달해도 문제 없음
        soundAnimal(donkey);
        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(chicken);
    }

    private static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
