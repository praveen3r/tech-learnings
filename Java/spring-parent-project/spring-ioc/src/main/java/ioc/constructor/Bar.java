package ioc.constructor;

public class Bar {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bar() {
        System.out.println("Bar...");
    }
}
