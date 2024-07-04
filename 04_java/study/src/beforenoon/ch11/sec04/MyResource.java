package beforenoon.ch11.sec04;

// 문제5) 다음과 같이 자원 클래스를 정의하고, AutoCloseable 인터페이스를 구현하세요.
// AutoCloseable 인터페이스를 구현한 객체는 리소스 자동 닫기 가능
public class MyResource implements AutoCloseable {
    private String name;

    public MyResource(String name) {
        this.name = name;
        System.out.println("[MyResource(" + name + ") 열기]");
    }

    public String read1() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "100";
    }

    public String read2() {
        System.out.println("[MyResource(" + name + ") 읽기]");
        return "abc";
    }

    // 추상 메서드 구현
    @Override
    public void close() throws Exception {
        System.out.println("[MyResource(" + name + ") 닫기]");
    }
}
