package simpleFactory;

public class Main {
    public static void main(String[] args) {
        Operation operate = OperationFactory.createOperate("+");
        operate.setNumberA(1);
        operate.setNumberB(2);
        System.out.println(operate.getResult());
    }
}
