package state;

public class ConcreteStateA extends State {
    @Override
    void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
