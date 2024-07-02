package afternoon.nested.inner.ex3;

public class OuterClass2Main {
    public static void main(String[] args) {
//        OuterClass2 outer = new OuterClass2();
//        OuterClass2.InnerClass inner = outer.new InnerClass();

        OuterClass2.InnerClass inner = new OuterClass2().new InnerClass();

        inner.hello();
    }
}
