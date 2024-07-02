package afternoon.nested.local.ex3;

public class AnonymousMain {
    public static void main(String[] args) {
        Hello hello = new Hello() { // Hello 익명 클래스, 인터페이스 직접 구현
            // 중괄호 안에 원하는 코드 작성, 담아서 인스턴스화 해서 보냄
            @Override
            public void hello() {
                System.out.println("hello");
            }
        };

        hello.hello();
    }
}
