package org.example;

import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserDao userDao = new UserDao(); // ctrl + alt + v

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

        // id가 1인 회원 조회
        List<UserVo> users2 = userDao.getSelectUser(1);

        for (UserVo user : users2) {
            System.out.println(user);
        }

        // 회원 수정
//        UserVo userUpdate = new UserVo(1, "isu", "1212");
//        userDao.updateUser(userUpdate);

        // 회원 삭제
//        userDao.deleteUser(4);

    }
}
