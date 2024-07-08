package afternoon.generic.limit;

public class LongWorld {
    private Long number;

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double transDouble() {
        // Integer 타입을 Double 로 바뀌줌
        return number.doubleValue();
    }

    @Override
    public String toString() {
        return "IntegerWorld{" +
                "number=" + number +
                '}';
    }
}
