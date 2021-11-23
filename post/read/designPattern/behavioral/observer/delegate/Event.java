package observer.delegate;

import java.lang.reflect.Method;

/**
 * 事件对象
 */
public class Event {
    private Object object;//对象
    private String methodName;//方法名
    private Object[] params;//参数
    private Class[] paramTypes;//参数类型

    public Event() {
    }

    public Event(Object object, String methodName, Object... args) {
        this.object = object;
        this.methodName = methodName;
        this.params = args;
        contractParamTypes(this.params);
    }

    //根据参数获取参数类型
    private void contractParamTypes(Object[] params) {
        this.paramTypes = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            this.paramTypes[i] = params[i].getClass();
        }
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    /**
     * 执行事件
     *
     * @throws Exception
     */
    public void invoke() throws Exception {
        Method method = object.getClass().getMethod(this.getMethodName(), this.getParamTypes());
        if (method == null) return;
        method.invoke(this.getObject(), this.getParams());
    }
}
