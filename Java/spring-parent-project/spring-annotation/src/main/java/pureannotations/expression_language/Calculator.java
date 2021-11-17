package pureannotations.expression_language;

//TODO : Reference
//https://www.baeldung.com/spring-expression-language

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    //Arithmetic Operators
    @Value("#{19 + 1}") // 20
    private double add;

    @Value("#{'String1 ' + 'string2'}") // "String1 string2"
    private String addString;

    @Value("#{20 - 1}") // 19
    private double subtract;

    @Value("#{10 * 2}") // 20
    private double multiply;

    @Value("#{36 / 2}") // 19
    private double divide;

    @Value("#{36 div 2}") // 18, the same as for / operator
    private double divideAlphabetic;

    @Value("#{37 % 10}") // 7
    private double modulo;

    @Value("#{37 mod 10}") // 7, the same as for % operator
    private double moduloAlphabetic;

    @Value("#{2 ^ 9}") // 512
    private double powerOf;

    @Value("#{(2 + 2) * 2 + 9}") // 17
    private double brackets;


    // Logical Operators

    @Value("#{1 == 1}") // true
    private boolean equal;

    @Value("#{1 eq 1}") // true
    private boolean equalAlphabetic;

    @Value("#{1 != 1}") // false
    private boolean notEqual;

    @Value("#{1 ne 1}") // false
    private boolean notEqualAlphabetic;

    @Value("#{1 < 1}") // false
    private boolean lessThan;

    @Value("#{1 lt 1}") // false
    private boolean lessThanAlphabetic;

    @Value("#{1 <= 1}") // true
    private boolean lessThanOrEqual;

    @Value("#{1 le 1}") // true
    private boolean lessThanOrEqualAlphabetic;

    @Value("#{1 > 1}") // false
    private boolean greaterThan;

    @Value("#{1 gt 1}") // false
    private boolean greaterThanAlphabetic;

    @Value("#{1 >= 1}") // true
    private boolean greaterThanOrEqual;

    @Value("#{1 ge 1}") // true
    private boolean greaterThanOrEqualAlphabetic;

    //Conditional Operators
    @Value("#{2 > 1 ? 'a' : 'b'}") // "a"
    private String ternary;

    //@Value("#{someBean.someProperty != null ? someBean.someProperty : 'default'}")
    private String ternary1;

   // @Value("#{someBean.someProperty ?: 'default'}") // Will inject provided string if someProperty is null
    private String elvis;

    //Using Regex in SpEL

    @Value("#{'100' matches '\\d+' }") // true
    private boolean validNumericStringResult;

    @Value("#{'100fghdjf' matches '\\d+' }") // false
    private boolean invalidNumericStringResult;

    @Value("#{'valid alphabetic string' matches '[a-zA-Z\\s]+' }") // true
    private boolean validAlphabeticStringResult;

    @Value("#{'invalid alphabetic string #$1' matches '[a-zA-Z\\s]+' }") // false
    private boolean invalidAlphabeticStringResult;

    //    @Value("#{someBean.someValue matches '\d+'}") // true if someValue contains only digits
    private boolean validNumericValue;

    public double getAdd() {
        return add;
    }

    public void setAdd(double add) {
        this.add = add;
    }

    public String getAddString() {
        return addString;
    }

    public void setAddString(String addString) {
        this.addString = addString;
    }

    public double getSubtract() {
        return subtract;
    }

    public void setSubtract(double subtract) {
        this.subtract = subtract;
    }

    public double getMultiply() {
        return multiply;
    }

    public void setMultiply(double multiply) {
        this.multiply = multiply;
    }

    public double getDivide() {
        return divide;
    }

    public void setDivide(double divide) {
        this.divide = divide;
    }

    public double getDivideAlphabetic() {
        return divideAlphabetic;
    }

    public void setDivideAlphabetic(double divideAlphabetic) {
        this.divideAlphabetic = divideAlphabetic;
    }

    public double getModulo() {
        return modulo;
    }

    public void setModulo(double modulo) {
        this.modulo = modulo;
    }

    public double getModuloAlphabetic() {
        return moduloAlphabetic;
    }

    public void setModuloAlphabetic(double moduloAlphabetic) {
        this.moduloAlphabetic = moduloAlphabetic;
    }

    public double getPowerOf() {
        return powerOf;
    }

    public void setPowerOf(double powerOf) {
        this.powerOf = powerOf;
    }

    public double getBrackets() {
        return brackets;
    }

    public void setBrackets(double brackets) {
        this.brackets = brackets;
    }

    public boolean isEqual() {
        return equal;
    }

    public void setEqual(boolean equal) {
        this.equal = equal;
    }

    public boolean isEqualAlphabetic() {
        return equalAlphabetic;
    }

    public void setEqualAlphabetic(boolean equalAlphabetic) {
        this.equalAlphabetic = equalAlphabetic;
    }

    public boolean isNotEqual() {
        return notEqual;
    }

    public void setNotEqual(boolean notEqual) {
        this.notEqual = notEqual;
    }

    public boolean isNotEqualAlphabetic() {
        return notEqualAlphabetic;
    }

    public void setNotEqualAlphabetic(boolean notEqualAlphabetic) {
        this.notEqualAlphabetic = notEqualAlphabetic;
    }

    public boolean isLessThan() {
        return lessThan;
    }

    public void setLessThan(boolean lessThan) {
        this.lessThan = lessThan;
    }

    public boolean isLessThanAlphabetic() {
        return lessThanAlphabetic;
    }

    public void setLessThanAlphabetic(boolean lessThanAlphabetic) {
        this.lessThanAlphabetic = lessThanAlphabetic;
    }

    public boolean isLessThanOrEqual() {
        return lessThanOrEqual;
    }

    public void setLessThanOrEqual(boolean lessThanOrEqual) {
        this.lessThanOrEqual = lessThanOrEqual;
    }

    public boolean isLessThanOrEqualAlphabetic() {
        return lessThanOrEqualAlphabetic;
    }

    public void setLessThanOrEqualAlphabetic(boolean lessThanOrEqualAlphabetic) {
        this.lessThanOrEqualAlphabetic = lessThanOrEqualAlphabetic;
    }

    public boolean isGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(boolean greaterThan) {
        this.greaterThan = greaterThan;
    }

    public boolean isGreaterThanAlphabetic() {
        return greaterThanAlphabetic;
    }

    public void setGreaterThanAlphabetic(boolean greaterThanAlphabetic) {
        this.greaterThanAlphabetic = greaterThanAlphabetic;
    }

    public boolean isGreaterThanOrEqual() {
        return greaterThanOrEqual;
    }

    public void setGreaterThanOrEqual(boolean greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
    }

    public boolean isGreaterThanOrEqualAlphabetic() {
        return greaterThanOrEqualAlphabetic;
    }

    public void setGreaterThanOrEqualAlphabetic(boolean greaterThanOrEqualAlphabetic) {
        this.greaterThanOrEqualAlphabetic = greaterThanOrEqualAlphabetic;
    }

    public String getTernary() {
        return ternary;
    }

    public void setTernary(String ternary) {
        this.ternary = ternary;
    }

    public String getTernary1() {
        return ternary1;
    }

    public void setTernary1(String ternary1) {
        this.ternary1 = ternary1;
    }

    public String getElvis() {
        return elvis;
    }

    public void setElvis(String elvis) {
        this.elvis = elvis;
    }

    public boolean isValidNumericStringResult() {
        return validNumericStringResult;
    }

    public void setValidNumericStringResult(boolean validNumericStringResult) {
        this.validNumericStringResult = validNumericStringResult;
    }

    public boolean isInvalidNumericStringResult() {
        return invalidNumericStringResult;
    }

    public void setInvalidNumericStringResult(boolean invalidNumericStringResult) {
        this.invalidNumericStringResult = invalidNumericStringResult;
    }

    public boolean isValidAlphabeticStringResult() {
        return validAlphabeticStringResult;
    }

    public void setValidAlphabeticStringResult(boolean validAlphabeticStringResult) {
        this.validAlphabeticStringResult = validAlphabeticStringResult;
    }

    public boolean isInvalidAlphabeticStringResult() {
        return invalidAlphabeticStringResult;
    }

    public void setInvalidAlphabeticStringResult(boolean invalidAlphabeticStringResult) {
        this.invalidAlphabeticStringResult = invalidAlphabeticStringResult;
    }

    public boolean isValidNumericValue() {
        return validNumericValue;
    }

    public void setValidNumericValue(boolean validNumericValue) {
        this.validNumericValue = validNumericValue;
    }
}
