package afternoon.extendss.access.child;

import afternoon.extendss.access.parent.Parent; // 패키지가 다르기 때문에 import

public class Child extends Parent {
    public void access() { // 접근 테스트
        System.out.println("publicValue : " + publicValue); // 어디서든 접근 가능
        System.out.println("protectedValue : " + protectedValue); // 패키지는 다르지만, 상속 관계라 가능
//        System.out.println("defaultValue : " + defaultValue); // 패키지가 달라서 불가능
//        System.out.println("privateValue : " + privateValue); // 같은 클래스가 아니므로 불가능

        publicMethod();
        protectedMethod();
//        defaultMethod();
//        privateMethod();
        printParent();
    }
}
