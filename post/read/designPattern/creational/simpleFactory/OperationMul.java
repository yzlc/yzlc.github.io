package simpleFactory;

public class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}
