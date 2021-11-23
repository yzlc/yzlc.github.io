package bridge;

public class Abstraction {
    Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }
    public void operation(){
        implementor.operation();
    }
}
