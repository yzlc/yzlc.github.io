package state;

public class ConcreteStateB extends State {
    @Override
    void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
