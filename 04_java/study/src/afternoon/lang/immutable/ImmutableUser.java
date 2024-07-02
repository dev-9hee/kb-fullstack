package afternoon.lang.immutable;

public class ImmutableUser {
    // 필드를 final 변수로 지정하여 생성 시점 이후 변경이 불가능 하도록 수정
    private final String name;

    // 생성자를 사용해야만 필드를 지정할 수 있게 설정, 최초 생성시 생성자를 통해서만 값을 지정 가능
    public ImmutableUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*
    // 값을 변경할 수 있는 setName() 은 삭제
    public void setName(String name) {
        this.name = name; // java: cannot assign a value to final variable name
    }
    */

    // 값을 변경 하는 것이 아니라 새로운 불변 객체를 만들어서 리턴하기
    // 메모리 낭비는 발생하지만 불변성은 유지하면서 일단 원하는 데이터는 전달이 가능!!
    public ImmutableUser setName(String name) {
        return new ImmutableUser(name);
    }

    @Override
    public String toString() {
        return "ImmutableUser{" +
                "name='" + name + '\'' +
                '}';
    }
}
