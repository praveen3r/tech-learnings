package pureannotations.concepts.autowired;

public class Number {
    @Override
    public String toString() {
        return "I am Number Class, Not Part of Alphabet Class";
    }

    public void init() {
        System.out.println("Init Method Called.");
    }

    public void cleanup() {
        System.out.println("Cleanup Method Called.");
    }

}
