package factoryMethod;

import simpleFactory.Operation;
import simpleFactory.OperationAdd;
import simpleFactory.OperationDiv;

public class DivFactory implements IFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}
