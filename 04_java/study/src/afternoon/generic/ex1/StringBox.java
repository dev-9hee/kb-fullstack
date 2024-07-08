package afternoon.generic.ex1;

// int 의 래퍼 타입인 Integer 를 보관하는 클래스
public class StringBox {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
