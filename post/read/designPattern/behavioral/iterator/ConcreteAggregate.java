package iterator;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    Iterator createIterator() {
        return new ConcreteIterator(this);
    }

    public int getCount() {
        return items.size();
    }

    public Object getItem(int index) {
        return items.get(index);
    }

    public void setItem(int index, Object value) {
        items.add(index, value);
    }
}
