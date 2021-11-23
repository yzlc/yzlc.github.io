package chainOfResponsibility;

public class ConcreteHandler1 extends Handler {
    @Override
    void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            System.out.printf("%s 处理请求 %s\n", this, request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
