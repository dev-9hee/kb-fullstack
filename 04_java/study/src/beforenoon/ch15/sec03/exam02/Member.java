package beforenoon.ch15.sec03.exam02;

public class Member {
    public String name;
    public int age;

    // 생성사
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // hashCode 재정의

    @Override
    public int hashCode() {
        // name.hashCode()는 name 객체의 해시 코드를 반환, 해시 코드는 객체를 고유하게 식별할 수 있는 정수 값
        return name.hashCode() + age;
    }

    // equals 재정의

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Member target) {
            return target.name.equals(name) && target.age == age;
        } else {
            return false;
        }
    }
}
