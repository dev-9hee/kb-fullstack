package afternoon.generic.ex1;

// 어떤 타입이 들어올지 몰라서 일단 '나중에' 정하겠다는 의미
public class GenericBox<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
