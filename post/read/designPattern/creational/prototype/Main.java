package prototype;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype1 p1 = new ConcretePrototype1("I");
        Prototype c1 = p1.Clone();
        System.out.println(c1.getId());
    }
}
