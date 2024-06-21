package afternoon.poly2;

public class AnimalMain2 {
    public static void main(String[] args) {
        Animal[] animals = { new Donkey(), new Dog(), new Cat(), new Chicken() };

        for (Animal animal : animals) { // : => in
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(Animal animal) {
        animal.sound();
    }
}
