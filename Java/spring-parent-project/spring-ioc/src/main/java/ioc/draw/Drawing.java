package ioc.draw;

public class Drawing {

    private Shape shape;

    public void drawShape() {
          shape.draw();
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
