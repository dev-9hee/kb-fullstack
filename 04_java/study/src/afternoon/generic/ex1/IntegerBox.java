package afternoon.generic.ex1;

// int 의 래퍼 타입인 Integer 를 보관하는 클래스
public class IntegerBox {
    private Integer value;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
