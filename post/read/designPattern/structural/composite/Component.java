package composite;

public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    abstract void add(Component c);
    abstract void remove(Component c);
    abstract void display(int depth);
}
