package ch03.sec01;

public class IncreaseDecreaseOperatorExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 10;
        int z;

        x++; // 11
        ++x; // 12
        System.out.println("x=" + x); // 12 출력
        System.out.println("--------------------");

        y--; // 9
        --y; // 8
        System.out.println("y=" + y); // 8 출력
        System.out.println("--------------------");

        z = x++; // z에 x값이 대입되고, 그 다음에 x값이 증가함
        System.out.println("z=" + z); // 12 출력
        System.out.println("x=" + x); // 13 출력
        System.out.println("--------------------");

        z = ++x;
        System.out.println("z=" + z); // 14 출력
        System.out.println("x=" + x); // 14 출력
        System.out.println("--------------------");

        z = ++x + y++; // z = 15 + 8 = 23
        System.out.println("z=" + z); // 23 출력
        System.out.println("x=" + x); // 15 출력
        System.out.println("y=" + y); // 9 출력
    }
}
