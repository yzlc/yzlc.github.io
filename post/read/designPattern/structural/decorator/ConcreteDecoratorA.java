package decorator;

public class ConcreteDecoratorA extends Decorator{
    private String addedState;

    @Override
    void operation() {
        super.operation();
        addedState="New State";
        System.out.println("具体装饰对象A的操作");
    }
}
