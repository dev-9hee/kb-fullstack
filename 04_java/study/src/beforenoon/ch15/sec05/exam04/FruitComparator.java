package beforenoon.ch15.sec05.exam04;

import java.util.Comparator;

public class FruitComparator implements Comparator<Fruit> {
    // 가격을 기준으로 오름차순 정렬
    @Override
    public int compare(Fruit o1, Fruit o2) {
        // o1의 가격이 o2의 가격보다 작으면 -1을 반환, 이는 o1이 o2보다 작다고 간주되어 TreeSet 에서 o1이 o2보다 앞에 위치하도록 함
        if(o1.price < o2.price) return -1;
        // o1의 가격이 o2의 가격과 같으면 0을 반환, 이는 o1과 o2가 동등하다고 간주되어 TreeSet 에서 중복된 항목으로 처리되지 않도록 함
        else if(o1.price == o2.price) return 0;
        // o1의 가격이 o2의 가격보다 크면 1을 반환, 이는 o1이 o2보다 크다고 간주되어 TreeSet 에서 o1이 o2보다 뒤에 위치하도록 함
        else return 1;
    }
}
