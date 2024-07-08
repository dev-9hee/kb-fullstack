package afternoon.generic.limit;

public class World2 {
    public static void main(String[] args) {
        GenericWorld<Integer> integerWorld = new GenericWorld<>();
        integerWorld.setNumber(10);
        System.out.println(integerWorld.getNumber());

        GenericWorld<Long> longWorld = new GenericWorld<>();
        longWorld.setNumber(20L);
        System.out.println(longWorld.getNumber());
    }
}
