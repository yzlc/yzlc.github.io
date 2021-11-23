package composite;

public class Main {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        root.add(new Leaf("leaf A"));
        root.add(new Leaf("leaf B"));

        Composite comp = new Composite("composite x");
        comp.add(new Leaf("leaf xA"));
        comp.add(new Leaf("leaf xB"));

        root.add(comp);

        Composite comp2 = new Composite("composite xy");
        comp2.add(new Leaf("leaf xyA"));
        comp2.add(new Leaf("leaf xyB"));

        comp.add(comp2);

        root.add(new Leaf("leaf c"));

        Leaf leaf = new Leaf("leaf D");
        root.add(leaf);
        root.remove(leaf);

        root.display(1);
    }
}
