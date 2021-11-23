package visitor;

public class ConcreteVisitor2 extends Visitor {
    @Override
    void visitConcreteElementA(ConcreteElementA concreteElementA) {
        System.out.printf("%s被%s访问\n",concreteElementA.getClass(),this.getClass());
    }

    @Override
    void visitConcreteElementB(ConcreteElementB concreteElementB) {
        System.out.printf("%s被%s访问\n",concreteElementB.getClass(),this.getClass());
    }
}
