package afternoon.abstractt;

// 순수 추상 클래스
abstract class AbstractAnimal {
    public abstract void sound(); // 구현 불가, abstract 클래스 내에서만 abstract 메서드 사용 가능

    public abstract void eat();
}
