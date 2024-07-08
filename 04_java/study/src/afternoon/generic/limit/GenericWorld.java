package afternoon.generic.limit;

// T 는 Number 타입 또는 Number 타입의 자손만 받을 수 있도록 타입 제한
public class GenericWorld<T extends Number> {

    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public double transDouble() {
//        return ((Number) number).doubleValue();
        return number.doubleValue();
    }

    @Override
    public String toString() {
        return "GenericWorld{" +
                "number=" + number +
                '}';
    }
}
