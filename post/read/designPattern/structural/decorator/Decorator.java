package decorator;

public abstract class Decorator extends Component {
    Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    void operation() {
        if (component != null)
            component.operation();
    }
}
