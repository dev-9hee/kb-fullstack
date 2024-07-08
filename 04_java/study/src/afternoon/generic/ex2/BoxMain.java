package afternoon.generic.ex2;

public class BoxMain {
    public static void main(String[] args) {
        StrictGenericBox<String> strictGenericBox1 = new StrictGenericBox<>();
        strictGenericBox1.setValue("hello");
        System.out.println("strictGenericBox1's value : " + strictGenericBox1.getValue());

        StrictGenericBox<Integer> strictGenericBox2 = new StrictGenericBox<>();
        strictGenericBox2.setValue(100);
        System.out.println("strictGenericBox2's value : " + strictGenericBox2.getValue());

        StrictGenericBox<Double> strictGenericBox3 = new StrictGenericBox<>();
        strictGenericBox3.setValue(3.0);
    }
}
