package pureannotations.concepts.basics;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
    private String name;

    public String test() {
        return "Hello Test Bean!";
    }
}
