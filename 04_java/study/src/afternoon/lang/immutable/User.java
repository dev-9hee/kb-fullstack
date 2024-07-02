package afternoon.lang.immutable;

public class User {
    private String name;

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
