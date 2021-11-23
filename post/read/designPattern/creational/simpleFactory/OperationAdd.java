package simpleFactory;

public class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}
