package chainOfResponsibility;

public class ConcreteHandler2 extends Handler {
    @Override
    void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.printf("%s 处理请求 %s\n", this, request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
