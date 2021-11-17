package ioc.dependson;

public class A {
    B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
    public A() {
        System.out.println("Default Constructor Bean A is initialized");
    }
    public A( B b1) {
        System.out.println("Bean A is initialized");
        System.out.println("Injection Check : " + b1);
    }

    {
        System.out.println("Normal Block Check : " + b);
    }
}
