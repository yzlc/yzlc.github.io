package factoryMethod;

import simpleFactory.Operation;
import simpleFactory.OperationAdd;
import simpleFactory.OperationMul;

public class MulFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationMul();
    }
}
