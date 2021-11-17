package ioc.constructor;

public class Foo {
    public Foo(Bar bar, Baz baz) {
        System.out.println(bar.getName());
        System.out.println(baz.getName());
    }

    public Foo(int i, float l) {
        System.out.println(i);
    }

    public Foo(String str) {
        System.out.println("String : " + str);
    }

    public Foo(int i) {
        System.out.println(i);
    }
}

