package ioc.inheritance.abstrct;

public class DerivedTestBean extends TestBean {
    public void initialize() {
        //super.setAge(10);
       // super.setName("i am child bean");
    }

    @Override
    public String toString() {
        return getName() + "       ---        " + getAge();
    }
}
