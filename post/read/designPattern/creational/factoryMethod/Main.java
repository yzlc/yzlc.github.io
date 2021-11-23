package factoryMethod;

import simpleFactory.Operation;

public class Main {
    public static void main(String[] args) {
        IFactory operFactory = new AddFactory();
        Operation oper = operFactory.createOperation();
        oper.setNumberA(1);
        oper.setNumberB(2);
        System.out.println(oper.getResult());
    }
}
