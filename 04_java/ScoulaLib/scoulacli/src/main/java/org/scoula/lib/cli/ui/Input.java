package org.scoula.lib.cli.ui;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String title) {
        System.out.println(title);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getLine(String title) {
        System.out.print(title);
        return scanner.nextLine();
    }

    public static String getLine(String title, String defaultValue) {
        // 이름(김길동):
        System.out.printf("%s(%s): ", title, defaultValue);
        String answer = scanner.nextLine();

        // 그냥 엔터 쳤으면 defaultValue 리턴, 입력값이 있으면 answer 리턴
        return answer.isEmpty() ? defaultValue : answer;
    }

    public static boolean confirm(String title) {
        return confirm(title, true);
    }

    public static boolean confirm(String title, boolean defaultValue) {
        String yesNo = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.printf("%s %s: ", title, yesNo);

        String answer = scanner.nextLine();
        if (answer.isEmpty())
            return defaultValue;
        return answer.equalsIgnoreCase("y");
    }
}
