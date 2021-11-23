package composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Composite extends Component {
    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    void add(Component c) {
        children.add(c);
    }

    @Override
    void remove(Component c) {
        children.remove(c);
    }

    @Override
    void display(int depth) {
        System.out.println(String.join("", Collections.nCopies(depth, "-")) + name);
        for (Component component : children) {
            component.display(depth + 2);
        }
    }
}
