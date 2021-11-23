package chainOfResponsibility;

public class ConcreteHandler3 extends Handler {
    @Override
    void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            System.out.printf("%s 处理请求 %s\n", this, request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
