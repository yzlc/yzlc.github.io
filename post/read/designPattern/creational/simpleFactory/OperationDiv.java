package simpleFactory;

public class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (getNumberB() == 0)
            throw new IllegalArgumentException("除数不能为0。");
        return getNumberA() / getNumberB();
    }
}
