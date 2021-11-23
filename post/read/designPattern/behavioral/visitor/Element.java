package visitor;

public abstract class Element {
    abstract void accept(Visitor visitor);
}
