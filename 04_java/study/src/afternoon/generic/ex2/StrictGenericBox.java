package afternoon.generic.ex2;

public class StrictGenericBox<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        if (value instanceof String || value instanceof Integer || value instanceof Long) {
            System.out.println("전달 받은 값이 String / Integer / Long 이 맞습니다!!!");
            this.value = value;
        } else {
            System.out.println("전달 받은 값이 String / Integer / Long 이 아닙니다...");

        }

    }
}
