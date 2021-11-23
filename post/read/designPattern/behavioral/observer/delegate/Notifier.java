package observer.delegate;

/**
 * 通知者
 */
public abstract class Notifier {
    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    /**
     * 添加事件
     *
     * @param object     对象
     * @param methodName 方法名
     * @param args       参数
     */
    public abstract void addListener(Object object, String methodName, Object... args);

    /**
     * 通知
     */
    public abstract void notifyX();
}
