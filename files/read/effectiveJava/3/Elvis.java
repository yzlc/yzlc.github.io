package effectiveJava.t3;

import java.io.Serializable;

public class Elvis implements Serializable {
    private Elvis() {
    }

    private transient static final Elvis INSTANCE = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
