package afternoon.abstractt;

public class AbstractAnimalMain {
    public static void main(String[] args) {
        AbstractAnimal[] animals = new AbstractAnimal[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Duck();

        for (AbstractAnimal animal : animals) {
            animalCall(animal);
        }
    }

    // 부모는 자식을 담을 수 있음
    static void animalCall(AbstractAnimal animal) {
        animal.eat();
        animal.sound();

        if (animal instanceof Duck) {
            Duck duck = (Duck) animal;
            duck.fly();
            // ((Duck) animal).fly();
        }
    }
}
