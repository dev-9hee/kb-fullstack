package afternoon.nested.nested;

public class OuterMain {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Nested nested = new Outer.Nested();
        nested.print();
    }
}
