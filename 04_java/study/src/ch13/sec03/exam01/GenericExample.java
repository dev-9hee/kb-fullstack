package ch13.sec03.exam01;

// 제네릭 타입 생략시 Object로 간주
public class GenericExample {
    // 제네릭 메소드
    public static <T> Box<T> boxing(T t) { // 타입 파라미터 정의, 리턴 타입, 메소드명(매개변수, ...) { ... }
        Box<T> box = new Box<T>();
        box.set(t);
        return box;
    }

    public static void main(String[] args) {
        // 제네릭 메소드 호출
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);

        // 제네릭 메소드 호출
        Box<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }
}
