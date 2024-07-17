package org.scoula.user2;

public class UserManageProgram {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        userDAO.getAllUsers();
    }
}
