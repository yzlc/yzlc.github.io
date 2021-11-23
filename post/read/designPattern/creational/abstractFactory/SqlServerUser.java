package abstractFactory;

public class SqlServerUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在sql server中给user表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在sql server中根据id得到user表一条记录");
        return null;
    }
}
