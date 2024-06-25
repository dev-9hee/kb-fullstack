package afternoon.poly3.casting1;

public class PolyMain1 {
    public static void main(String[] args) {
        Child child = new Child(); // new Child() 쓰고 ctrl + alt + v

        child.childMethod();
        child.parentMethod();

        System.out.println();

        Parent parent = new Child();

        parent.parentMethod();
        // 생성은 되었지만, Parent 타입의 범위에서 데이터타입이라는 벽에 막혀서 못 감, 못 찾아~!
        //        parent.childMethod(); // 데이터 타입의 한계로 접근 불가

        // 해결 방법 1
//        Child poly = (Child) parent;
//        poly.childMethod();

        // 해결 방법 2
        ((Child) parent).childMethod();
    }
}
