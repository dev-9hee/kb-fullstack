package afternoon.generic.limit;

public class World1 {
    public static void main(String[] args) {
        IntegerWorld integerWorld1 = new IntegerWorld();
        integerWorld1.setNumber(10);
        System.out.println(integerWorld1.getNumber());

        LongWorld longWorld1 = new LongWorld();
        longWorld1.setNumber(20L);
        System.out.println(longWorld1.getNumber());
    }
}
