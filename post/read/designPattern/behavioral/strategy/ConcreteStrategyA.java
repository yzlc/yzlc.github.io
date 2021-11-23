package strategy;

//具体算法A
public class ConcreteStrategyA extends Strategy {
    //算法A实现方法
    @Override
    void algorithmInterface() {
        System.out.println("算法A实现");
    }
}
