package beforenoon.ch15.sec05.exam04;

import java.util.TreeSet;

public class ComparatorExample {
    public static void main(String[] args) {
        // 비교자를 제공한 TreeSet 컬렉션 생성, TreeSet 을 생성할 때 FruitComparator 를 전달
        // FruitComparator 는 Fruit 객체들을 가격에 따라 오름차순으로 정렬
        // 따라서 TreeSet 에 추가된 Fruit 객체들은 가격 순서대로 정렬
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new FruitComparator());

        // 객체 저장, 가격을 기준으로 오름차순 정렬
        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        // 객체를 하나씩 가져오기
        for(Fruit fruit : treeSet) {
            System.out.println(fruit.name + ":" + fruit.price);
        }
    }
}
