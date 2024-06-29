package afternoon.poly4.ex;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Duck()};

        for (Animal animal : animals) {
            animalDo(animal);

            if (animal instanceof Fly) {
                flyDo((Fly) animal);
            }
        }
    }

    public static void animalDo(Animal animal) {
        animal.sound();
        animal.eat();
    }

    public static void flyDo(Fly fly) {
        fly.fly();
    }
}
