package observer;

public class Main {
    public static void main(String[] args) {
        ConcreteSubject s = new ConcreteSubject();
        s.attach(new ConcreteObserver(s, "X"));
        s.attach(new ConcreteObserver(s, "Y"));
        s.attach(new ConcreteObserver(s, "Z"));

        s.setSubjectState("ABC");
        s.Notify();
    }
}