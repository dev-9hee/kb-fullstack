package ch13.sec01;

public class GenericExample {
    public static void main(String[] args) {
        // Box<String> box1 = new Box<String>();
        Box<String> box1 = new Box<>(); // Box 생성시 타입파라미터 대신 String 으로 대체
        box1.content = "안녕하세요.";
        String str = box1.content; // 강제 타입 변환이 필요없이 사용 가능
        System.out.println(str);

        Box<Integer> box2 = new Box<>(); // Box 생성시 타입파라미터 대신 Integer 로 대체
        box2.content = 100;
        int value = box2.content; // 강제 타입 변환이 필요없이 사용 가능
        System.out.println(value);
    }
}
