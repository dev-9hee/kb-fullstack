package org.example;

import java.util.List;

public class UserMainV2 {
    public static void main(String[] args) {
        UserDaoV2 userDao = new UserDaoV2(); // ctrl + alt + v

        // 회원 추가, 이제는 객체를 전달
//        UserVo newUser = new UserVo(0, "jihee", "1234");
//        userDao.addUser(newUser);

        // 모든 회원 조회
        List<UserVo> users = userDao.getAllUsers();

        for (UserVo user : users) {
//            System.out.print("아이디는 : " + user.getId() + " / ");
//            System.out.print("이메일은 : " + user.getEmail() + " / ");
//            System.out.print("비번은 : " + user.getPassword() + " / \n");
            System.out.println(user);
        }

        userDao.close();
    }
}
