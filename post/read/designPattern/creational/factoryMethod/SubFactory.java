package factoryMethod;

import simpleFactory.Operation;
import simpleFactory.OperationAdd;
import simpleFactory.OperationSub;

public class SubFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}
