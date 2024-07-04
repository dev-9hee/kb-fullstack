package beforenoon.ch13.sec02.exam03;

// 제네릭 타입 생략 시 Object 로 간주
public class GenericExample {
    public static void main(String[] args) {
        Box box1 = new Box();
        box1.content = "100";

        Box box2 = new Box();
        box2.content = "100";

        Box box3 = new Box();
        box3.content = 100;

        boolean result1 = box1.compare(box2); // true
        System.out.println("result1 = " + result1);

        boolean result2 = box1.compare(box3); // false
        System.out.println("result2 = " + result2);
    }
}
