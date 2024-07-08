package afternoon.generic.method;

public class GenericMethod {
    public static <T> T genericMethod(T t) { // 전달 받은 타입을 리턴 타입으로 지정
        System.out.println("t = " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t) { // 숫자 타입만 받을거야
        System.out.println("t = " + t);
        return t;
    }
}
