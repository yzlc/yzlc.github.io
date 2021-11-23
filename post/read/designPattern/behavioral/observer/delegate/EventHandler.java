package observer.delegate;

import java.util.ArrayList;
import java.util.List;

/**
 * 事件处理者
 */
public class EventHandler {
    private List<Event> objects;

    public EventHandler() {
        objects = new ArrayList<>();
    }

    //添加事件
    public void addEvent(Object object, String methodName, Object... args) {
        objects.add(new Event(object, methodName, args));
    }

    //通知所有的对象执行事件
    public void notifyX() throws Exception {
        for (Event e : objects) {
            e.invoke();
        }
    }
}
