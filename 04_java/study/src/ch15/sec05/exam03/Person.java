package ch15.sec05.exam03;

// Comparable 과 Comparator : TreeSet 에 저장되는 객체와 TreeMap 에 저장되는 키 객체를 정렬
// Comparable 인터페이스에는 compareTo() 메소드가 정의, 이 메소드를 재정의해서 비교 결과를 정수 값으로 리턴
public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if(age<o.age) return -1; // 주어진 객체보다 적으면 음수 리턴
        else if(age == o.age) return 0; // 주어진 객체와 같으면 0 리턴
        else return 1; // 주어진 객체보다 크면 양수 리턴
    }
}
