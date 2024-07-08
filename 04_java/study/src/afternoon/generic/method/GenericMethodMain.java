package afternoon.generic.method;

public class GenericMethodMain {
    public static void main(String[] args) {
        Integer value = GenericMethod.<Integer>genericMethod(10);
        Integer value2 = GenericMethod.<Integer>numberMethod(10);
    }
}
