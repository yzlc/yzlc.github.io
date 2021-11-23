package prototype;

public class ConcretePrototype1 extends Prototype implements Cloneable {
    public ConcretePrototype1(String id) {
        super(id);
    }

    @Override
    Prototype Clone() throws CloneNotSupportedException {
        return (Prototype) this.clone();
    }
}
