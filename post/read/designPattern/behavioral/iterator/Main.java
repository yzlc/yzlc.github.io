package iterator;

public class Main {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.setItem(0, "大鸟");
        a.setItem(1, "小菜");
        a.setItem(2, "行李");
        a.setItem(3, "老外");
        a.setItem(4, "公交内部员工");
        a.setItem(5, "小偷");

        Iterator i = new ConcreteIterator(a);
        while (!i.isDone()) {
            System.out.printf("%s 请买车票！\n", i.currentItem());
            i.next();
        }
    }
}
