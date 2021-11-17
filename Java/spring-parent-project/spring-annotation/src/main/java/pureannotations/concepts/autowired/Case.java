package pureannotations.concepts.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Case {
//    public Case(String type) {
//        this.type = type;
//    }

    @Value("LowerCase")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Alphabet Letters Case Type -" + getType();
    }
}
