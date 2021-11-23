package flyweight;

public class UnsharedConcreteFlyweight extends Flyweight {
    @Override
    void operation(int extrinsicstate) {
        System.out.println("不共享的具体 Flyweight：" + extrinsicstate);
    }
}
