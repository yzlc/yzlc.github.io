package abstractFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        Department department = new Department();

        IUser iu = DataAccess.createUser();

        iu.insert(user);
        iu.getUser(1);

        IDepartment id = DataAccess.createDepartment();
        id.insert(department);
        id.getDepartment(1);
    }
}
