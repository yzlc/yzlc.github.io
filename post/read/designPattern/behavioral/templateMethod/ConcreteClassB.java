package templateMethod;

public class ConcreteClassB extends AbstractClass {
    @Override
    void primitiveOperation1() {
        System.out.println("具体类B方法1实现");
    }

    @Override
    void primitiveOperation2() {
        System.out.println("具体类B方法2实现");
    }
}
