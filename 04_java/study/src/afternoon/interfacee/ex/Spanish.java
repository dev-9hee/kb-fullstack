package afternoon.interfacee.ex;

public class Spanish implements Human{
    @Override
    public void speak() {
        System.out.println("Hola");
    }

    @Override
    public void eat() {
        System.out.println("El español come paella");
    }

    @Override
    public void hello() {
        System.out.println("Hola. Actualmente es el año " + CURRENT_YEAR);
    }
}
