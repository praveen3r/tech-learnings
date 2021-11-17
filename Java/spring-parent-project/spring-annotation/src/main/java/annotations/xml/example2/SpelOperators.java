package annotations.xml.example2;

public class SpelOperators {

    private boolean equal;
    private boolean notEqual;
    private boolean greaterThanOrEqual;
    private boolean and;
    private boolean or;
    private String addString;

    // Getters and setters


    public boolean isEqual() {
        return equal;
    }

    public void setEqual(boolean equal) {
        this.equal = equal;
    }

    public boolean isNotEqual() {
        return notEqual;
    }

    public void setNotEqual(boolean notEqual) {
        this.notEqual = notEqual;
    }

    public boolean isGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    public void setGreaterThanOrEqual(boolean greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
    }

    public boolean isAnd() {
        return and;
    }

    public void setAnd(boolean and) {
        this.and = and;
    }

    public boolean isOr() {
        return or;
    }

    public void setOr(boolean or) {
        this.or = or;
    }

    public String getAddString() {
        return addString;
    }

    public void setAddString(String addString) {
        this.addString = addString;
    }
}
