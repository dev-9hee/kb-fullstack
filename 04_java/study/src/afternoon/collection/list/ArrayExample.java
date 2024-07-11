package afternoon.collection.list;

import java.util.ArrayList;

public class ArrayExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // 리스트 추가, 1 2 3 4 5
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("list = " + list);

        list.add(6); // 추가가 용이함

        System.out.println("list = " + list);
    }
;}
