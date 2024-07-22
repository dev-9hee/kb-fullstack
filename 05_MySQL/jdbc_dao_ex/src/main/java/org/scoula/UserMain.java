package org.scoula;

public class UserMain {
    public static void main(String[] args) {
        UserDao userDao = new UserDao(); // UserDao 를 인스턴스화

//        UserVo tetz = new UserVo(1, "tetz", "1234");
//        System.out.println(tetz);
//
//        // 회원 추가
//        userDao.create("tetz2", "1234");
//        // 추가 회원 조회
//        userDao.getAllUsers();
//
//        // id가 7인 회원 수정 메서드 실행
//        userDao.updateUser(7, "jihee", "0420");
//        // 수정 회원 조회
//        userDao.getAllUsers();
//
//        // id가 7인 회원 삭제 메서드 실행
//        userDao.deleteUser(7);
//        // 삭제 회원 조회
//        userDao.getAllUsers();

        userDao.getAllUsers(); // 이름이 출력 안되는 회원 조회 메서드
        userDao.getAllUsersWithName(); // 이름이 출력되는 회원 조회 메서드
    }
}
