package visitor;

public class ConcreteElementA extends Element {
    @Override
    void accept(Visitor visitor) {
        visitor.visitConcreteElementA(this);
    }

    public void operationA(){}
}
