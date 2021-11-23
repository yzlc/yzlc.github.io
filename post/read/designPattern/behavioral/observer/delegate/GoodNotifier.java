package observer.delegate;

public class GoodNotifier extends Notifier {
    @Override
    public void addListener(Object object, String methodName, Object... args) {
        System.out.println("添加监听事件");
        EventHandler handler = this.getEventHandler();
        handler.addEvent(object, methodName, args);
    }

    @Override
    public void notifyX() {
        System.out.println("通知");
        try {
            getEventHandler().notifyX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
