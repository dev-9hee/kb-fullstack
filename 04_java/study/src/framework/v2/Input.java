package framework.v2;

import java.util.Scanner;

// 입력 기능
public class Input {
    static Scanner sc = new Scanner(System.in);

    public static int getInt(String title) {
        System.out.print(title);
        return Integer.parseInt(sc.nextLine());
    }
}
