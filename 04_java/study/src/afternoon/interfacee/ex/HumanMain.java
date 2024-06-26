package afternoon.interfacee.ex;

public class HumanMain {
    public static void main(String[] args) {
        Human[] humans = {new Korean(), new American(), new Spanish()};

        for (Human h : humans) {
            humanCall(h);
        }
    }

    public static void humanCall(Human h) {
        h.speak();
        h.eat();
        h.hello();
        System.out.println();
    }
}
