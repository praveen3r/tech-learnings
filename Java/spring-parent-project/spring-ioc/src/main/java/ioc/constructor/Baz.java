package ioc.constructor;

public class Baz {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Baz() {
        System.out.println("Bar...");
    }
}
