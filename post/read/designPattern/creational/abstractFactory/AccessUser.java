package abstractFactory;

public class AccessUser implements IUser {
    @Override
    public void insert(User user) {
        System.out.println("在access中给user表增加一条记录");
    }

    @Override
    public User getUser(int id) {
        System.out.println("在access中根据id得到user表一条记录");
        return null;
    }
}
