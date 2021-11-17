package ioc.autowiring;

public class A implements Alphabet {

    /*A(A a2, B b2,C c2) {
        System.out.println("A.B.C is created");
    }*/

    A(B b1, C c1) {
        this.b = b1;
        System.out.println("A.C is created");
    }

    A(B c, B b1) {
        System.out.println(c + " " +b1);
        this.b = b1;
        System.out.println("A.BB is created");
    }

    A() {
        System.out.println("A is created");
    }
    String b1;
    B b2;

    public B getB2() {
        return b2;
    }

    public void setB2(B b2) {
        this.b2 = b2;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    void print() {
        System.out.println("hello A");
    }

    void display() {
        print();
        b.print();
    }
}