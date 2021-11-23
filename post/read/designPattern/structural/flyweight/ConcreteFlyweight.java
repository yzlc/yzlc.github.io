package flyweight;

public class ConcreteFlyweight extends Flyweight {
    @Override
    void operation(int extrinsicstate) {
        System.out.println("具体 Flyweight：" + extrinsicstate);
    }
}
