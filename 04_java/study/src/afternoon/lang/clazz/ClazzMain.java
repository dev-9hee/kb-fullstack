package afternoon.lang.clazz;

import java.lang.reflect.Field;

public class ClazzMain {
    public static void main(String[] args) throws Exception{
        Class clazz1 = User.class; // 1. 클래스에서 직접 조회
        Class clazz2 = new User("정지희").getClass(); // 2. 인스턴스를 만들어서 조회
        Class clazz3 = Class.forName("afternoon.lang.clazz.User"); // 3. 문자열로 찾아서 조회

        // 모든 필드(멤버 변수)
        Field[] fields = clazz1.getDeclaredFields(); // 필드 정보 받음
        for (Field field : fields) {
            System.out.println("field = " + field);
        }

        // 상위 클래스 정보 출력, 클래스는 다중 상속 불가
        System.out.println("상위 클래스 = " + clazz1.getSuperclass()); // 상속을 받지 앟았어도 Object 클래스를 묵시적으로 상속

        // 상위 인터페이스 정보 출력, 인터페이스는 다중 구현 가능, 배열로 받음
        Class[] interfaces = clazz1.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("상위 인터페이스 = " + i);
        }

        // Class 정보를 바탕으로 인스턴스 만들기
        User user = (User) clazz1.getDeclaredConstructor().newInstance();
        System.out.println("user = " + user);
        user.setName("지희");
        System.out.println("user = " + user);
    }
}
