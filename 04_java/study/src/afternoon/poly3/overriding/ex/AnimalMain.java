package afternoon.poly3.overriding.ex;

public class AnimalMain {
    public static void main(String[] args) {
        Animal[] animals = {new Animal(), new Dog(), new Cat(), new Duck()};

        for(Animal animal : animals) {
            animalCall(animal);
        }
    }

    public static void animalCall(Animal animal) {
        animal.sound();

        if (animal instanceof Duck) {
            ((Duck) animal).fly();
        }
    }
}
