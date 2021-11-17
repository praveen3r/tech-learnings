package ioc.constructor;

public class ExampleBean {
    // Number of years to calculate the Ultimate Answer
    private int years;
    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    private Double aDouble;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
    public ExampleBean(int years, String ultimateAnswer,Double aDouble) {
    }


}
