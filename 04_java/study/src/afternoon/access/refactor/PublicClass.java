package afternoon.access.refactor;

// public class 는 무조건 한 개
public class PublicClass {
    public static void main(String[] args) {
        PublicClass pc = new PublicClass(); // Public 이므로 어디서든 호출 가능
        DefaultClass1 dc1 = new DefaultClass1(); // Default 이므로 클래스 내부에서는 문제 없이 호출 가능, 같은 패키지
        DefaultClass2 dc2 = new DefaultClass2();
    }
}

class DefaultClass1 {}

class DefaultClass2 {}
