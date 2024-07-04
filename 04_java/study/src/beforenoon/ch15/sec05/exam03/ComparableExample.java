package beforenoon.ch15.sec05.exam03;

import java.util.TreeSet;

public class ComparableExample {
    public static void main(String[] args) {
        // TreeSet 컬렉션 생성
        TreeSet<Person> treeSet = new TreeSet<Person>(); // Person 타입으로 리턴

        // 객체 저장, 나이를 기준으로 오름차순 정렬
        treeSet.add(new Person("홍길동", 45));
        treeSet.add(new Person("김자바", 25));
        treeSet.add(new Person("박지원", 31));

        // 객체를 하나씩 가져오기
        for(Person person : treeSet) {
            System.out.println(person.name + ":" + person.age);
        }
    }
}
