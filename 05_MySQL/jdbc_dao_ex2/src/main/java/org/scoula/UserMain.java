package org.scoula;

public class UserMain {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();

        // 회원 추가
//        userDao.create("tetz2", "1234");
        // 추가 회원 조회
//        userDao.getAllUsers();
//
        // id가 4인 회원 수정 메서드 실행
//        userDao.updateUser(4, "jihee", "0420");
//        // 수정 회원 조회
//        userDao.getAllUsers();
//
//        // id가 4인 회원 삭제 메서드 실행
//        userDao.deleteUser(4);
//        // 삭제 회원 조회
        userDao.getAllUsers();
        userDao.getAllUsersWithName();
    }
}
