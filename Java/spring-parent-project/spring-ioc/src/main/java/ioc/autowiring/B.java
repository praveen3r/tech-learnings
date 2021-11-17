package ioc.autowiring;


public class B implements Alphabet {
    B() {
        System.out.println("B is created");
    }

    void print() {
        System.out.println("hello B");
    }
}