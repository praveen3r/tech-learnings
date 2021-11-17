package ioc.draw;

public class Circle  extends ShapeAbstract{
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;

    public void draw() {
        System.out.println("Type"+getType());
    }
}
