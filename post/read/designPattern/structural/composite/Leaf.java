package composite;

import java.util.Collections;

public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    void add(Component c) {
        System.out.println("cannot add to a leaf");
    }

    @Override
    void remove(Component c) {
        System.out.println("cannot remove from a leaf");
    }

    @Override
    void display(int depth) {
        System.out.println(String.join("", Collections.nCopies(depth, "-")) + name);
    }
}
