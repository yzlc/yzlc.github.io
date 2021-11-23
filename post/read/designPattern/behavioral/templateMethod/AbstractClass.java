package templateMethod;

public abstract class AbstractClass {
    abstract void primitiveOperation1();

    abstract void primitiveOperation2();

    public void templateMethod() {
        primitiveOperation1();
        primitiveOperation2();
        System.out.println("");
    }
}
