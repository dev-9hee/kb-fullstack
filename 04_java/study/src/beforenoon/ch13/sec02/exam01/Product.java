package beforenoon.ch13.sec02.exam01;

// 외부에서 제네릭 타입을 사용하려면 타입 파라미터에 구체적인 타입을 지정
// 지정하지 않으면 Object 타입이 암묵적으로 사용
public class Product<K, M> { // 타입 파라미터로 K와 M 정의
    // 타입 파라미터를 필드 타입으로 사용
    private K kind;
    private M model;

    // 타입 파라미터를 리턴 타입과 매개 변수 타입으로 사용
    public K getKind() { return this.kind; } // K 타입으로 리턴
    public M getModel() { return this.model; } // M 타입으로 리턴
    public void setKind(K kind) { this.kind = kind; } // K 타입의 kind 매개 변수
    public void setModel(M model) { this.model = model; }
}
