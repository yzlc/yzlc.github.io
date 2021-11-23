package abstractFactory;

import util.PropertiesUtil;

public class DataAccess {
    private static final String assemblyName = "abstractFactory";
    private static final String db = PropertiesUtil.readValue("app.config", "db");

    public static IUser createUser() throws Exception {
        String className = assemblyName + "." + db + "User";
        return (IUser) Class.forName(className).newInstance();
    }

    public static IDepartment createDepartment() throws Exception {
        String className = assemblyName + "." + db + "Department";
        return (IDepartment) Class.forName(className).newInstance();
    }
}
