package proxy;

public class Proxy extends Subject {
    RealSubject realSubject;

    @Override
    void request() {
        if (realSubject == null)
            realSubject = new RealSubject();
        realSubject.request();
    }
}
