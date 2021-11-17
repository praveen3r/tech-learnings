package com.demo.sampleprog.common;


//        The class is not yet initialized.
//        The class is being initialized by the current thread: a recursive request for initialization.
//        The class is being initialized by
//        some thread other than the current thread.
//        The class is already initialized

public class Lazy {
    private static boolean initialized = false;

    static {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                initialized = true;
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("initialized :-" + initialized);
    }
}

