package iterator;

public class ConcreteIterator extends Iterator {
    private ConcreteAggregate aggregate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggregate) {
        this.aggregate = aggregate;
    }

    @Override
    Object first() {
        return aggregate.getItem(0);
    }

    @Override
    Object next() {
        Object ret = null;
        current++;
        if (current < aggregate.getCount())
            ret = aggregate.getItem(current);
        return ret;
    }

    @Override
    boolean isDone() {
        return current >= aggregate.getCount();
    }

    @Override
    Object currentItem() {
        return aggregate.getItem(current);
    }
}
