package org.scoula.user2;

import java.sql.Timestamp;
import java.util.Objects;

public class OldUserVO {
    // 객체의 필드를 전부 불변으로 설정
    private final int id;
    private final String userid;
    private final String name;
    private final String password;
    private final int age;
    private final boolean membership;
    private final Timestamp signupDate;

    // 최초 생성시에만 값의 부여가 가능하므로 생성자 설정
    public OldUserVO(int id, String userid, String name, String password, int age, boolean membership, Timestamp signupDate) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.age = age;
        this.membership = membership;
        this.signupDate = signupDate;
    }

    // 객체의 값을 변경하지 못하고 값만 받을 수 있도록 Getter 만 설정
    public int getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMembership() {
        return membership;
    }

    public Timestamp getSignupDate() {
        return signupDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OldUserVO oldUserVO = (OldUserVO) o;
        return id == oldUserVO.id && age == oldUserVO.age && membership == oldUserVO.membership && Objects.equals(userid, oldUserVO.userid) && Objects.equals(name, oldUserVO.name) && Objects.equals(password, oldUserVO.password) && Objects.equals(signupDate, oldUserVO.signupDate);
    }
}
