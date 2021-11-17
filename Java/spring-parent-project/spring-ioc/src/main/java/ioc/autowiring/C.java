package ioc.autowiring;

public class C {
    Integer b1;

    public Integer getB1() {
        return b1;
    }

    public void setB1(Integer b1) {
        this.b1 = b1;
    }

    B b2;

    public B getB2() {
        return b2;
    }

    public void setB2(B b2) {
        this.b2 = b2;
    }

   Alphabet alphabet;

    A a1;
    A a2;

    public A getA2() {
        return a2;
    }

    public void setA2(A a2) {
        this.a2 = a2;
    }



    public A getA1() {
        return a1;
    }

    public void setA1(A a1) {
        this.a1 = a1;
    }

    public Alphabet getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
}