package factoryMethod;

import simpleFactory.Operation;
import simpleFactory.OperationAdd;

public class AddFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
