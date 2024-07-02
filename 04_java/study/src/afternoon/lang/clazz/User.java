package afternoon.lang.clazz;

public class User {
    private String name;

    public User() {} // getDeclaredConstructor() 은 기본 생성자만 가져오므로 추가 해줌

    public User(String name) {
        this.name = name;
    }

    // getter, 값을 리턴
    public String getName() {
        return name;
    }

    // setter, 값을 설정
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
