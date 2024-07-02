package ch13.sec01;

// 프리미티브 데이터 타입은 제네릭으로 사용 불가, 참조형에 대해서만 사용 가능
// wrapper 클래스 사용 => 제네릭 배정 ex> Integer...
public class Box<T> { // T : 타입 파라미터, 타입 결정을 나중에 하겠다..
    public T content;
}
