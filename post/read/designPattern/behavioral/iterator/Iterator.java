package iterator;

public abstract class Iterator {
    abstract Object first();
    abstract Object next();
    abstract boolean isDone();
    abstract Object currentItem();
}
