package abstractFactory;

public class AccessDepartment implements IDepartment {
    @Override
    public void insert(Department department) {
        System.out.println("在access中给Department表增加一条记录");
    }

    @Override
    public Department getDepartment(int id) {
        System.out.println("在access中根据id得到Department表一条记录");
        return null;
    }
}
