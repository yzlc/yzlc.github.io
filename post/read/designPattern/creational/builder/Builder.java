package builder;

abstract class Builder {
    abstract void buildPartA();
    abstract void buildPartB();
    abstract Product getResult();
}
