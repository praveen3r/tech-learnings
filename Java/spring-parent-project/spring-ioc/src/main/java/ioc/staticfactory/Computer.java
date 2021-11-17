package ioc.staticfactory;

public class Computer {
    public Computer() {

    }

    public static final Computer COMPUTER = new Computer("DELL COMPUTERS");

    public Computer(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    {
        System.out.println("Normal Block!");
    }

    static class Processor {
        static {
            System.out.println("Static Block!");
        }

        private String name;
        public static Integer modelNo;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static Integer getModelNo() {
            return modelNo;
        }

        public static void setModelNo(Integer modelNo) {
            Processor.modelNo = modelNo;
        }
    }
}
