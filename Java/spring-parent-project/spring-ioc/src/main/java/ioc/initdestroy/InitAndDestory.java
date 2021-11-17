package ioc.initdestroy;

public class InitAndDestory {

    public void cleanup() {
            // do some destruction work (like releasing pooled connections)
        System.out.println("Clean up.........");
    }

    public void destroy() {
            // do some destruction work (like releasing pooled connections)
        System.out.println("Destroy.");
    }
}
