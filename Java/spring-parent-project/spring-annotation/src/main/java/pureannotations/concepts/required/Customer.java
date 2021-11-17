package pureannotations.concepts.required;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Customer {
    @Value("RONAV")
    private String name;


    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Required
    @Value("100")
    public void setId(int id) {
        this.id = id;
    }
}
