package afternoon.lang.wrapper;

// 래퍼 클래스는 불변 객체이며, 보통 프로그램 최적화를 위해 한번 등록된 데이터는 캐시에 등록을 해놓고 사용
// new Integer()가 곧 삭제되는 이유 : 매번 새롭게 객체를 만들어 사용하면 최적화에 문제가 생기기 때문
public class WrapperClassMain {
    public static void main(String[] args) {
        Integer integer1 = new Integer(10); // 사용 x, new Integer()은 삭제 예정인 방법
        Integer integer2 = Integer.valueOf(10);
        Long long1 = Long.valueOf(100);
        Double double1 = Double.valueOf(11.18);

        // 래퍼 클래스를 원시형 데이터처럼 사용 가능 but,, 해당 데이터는 원시형이 아닌 객체!
        // 해당 값이 저렇게 표기되는 이유는 toString()이 전부 오버라이딩 되어 저렇게 출력 되도록 만들어져 있기 때문
        System.out.println("integer1 = " + integer1);
        System.out.println("integer2 = " + integer2);
        System.out.println("long1 = " + long1);
        System.out.println("double1 = " + double1);

        System.out.println();

        // 실제 값을 꺼내려면 각각에 맞는 메서드를 사용
        System.out.println(integer1.intValue());
        System.out.println(integer2.intValue());
        System.out.println(long1.longValue());
        System.out.println(double1.doubleValue());

        System.out.println();

        System.out.println(integer1 == integer2); // false
    }
}
