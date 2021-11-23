package flyweight;

public class Main {
    public static void main(String[] args) {
        int extrinsicstate = 22;

        FlyweightFactory f = new FlyweightFactory();

        Flyweight fx = f.getFlyweights("x");
        fx.operation(--extrinsicstate);

        Flyweight fy = f.getFlyweights("y");
        fy.operation(--extrinsicstate);

        Flyweight fz = f.getFlyweights("z");
        fz.operation(--extrinsicstate);

        UnsharedConcreteFlyweight uf = new UnsharedConcreteFlyweight();

        uf.operation(--extrinsicstate);
    }
}
