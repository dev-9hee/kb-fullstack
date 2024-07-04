package beforenoon.ch12.sec03.exam01;

// Object 클래스 : 클래스를 선언할 때 extends 키워드로 다른 클래스를 상속하지 않으면 암시적으로 java.lang.Object 클래스를 상속
// 자바의 모든 클래스는 Object 의 자식이거나 자손 클래스
public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    // 객체 동등 비교
    // Object 의 equals() 메소드는 객체의 번지를 비교하고 boolean 값을 리턴
    @Override
    public boolean equals(Object obj) {
        // obj 가 Member 타입의 객체인지 확인
        // 만약 맞다면, target 이라는 변수에 obj 를 Member 타입으로 캐스팅한 값이 할당
        if(obj instanceof Member target) { // 타입 검사
            if(id.equals(target.id)) { // id 문자열이 같은지 비교
                return true;
            }
        }
        return false;
    }
}
