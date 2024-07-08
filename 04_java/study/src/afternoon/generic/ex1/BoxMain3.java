package afternoon.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        GenericBox<Integer> integerGenericBox = new GenericBox<>();
        integerGenericBox.setValue(10);
        Integer integer = integerGenericBox.getValue();
        System.out.println("integer = " + integer);

        GenericBox<String> stringGenericBox = new GenericBox<>();
        stringGenericBox.setValue("hello");
        String string = stringGenericBox.getValue();
        System.out.println("string = " + string);
    }
}