package prototype;

public abstract class Prototype {
    private String id;
    public Prototype(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }
    abstract Prototype Clone() throws CloneNotSupportedException;
}
