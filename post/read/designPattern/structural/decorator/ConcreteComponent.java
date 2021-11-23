package decorator;

public class ConcreteComponent extends Component {
    @Override
    void operation() {
        System.out.println("具体对象的操作");
    }
}
