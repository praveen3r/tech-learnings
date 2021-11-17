package pureannotations.concepts.autowired;

import org.springframework.beans.factory.annotation.Value;

public class CTest implements Alphabet {
    @Value("Third Letter")
    private String name;
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Default value of CTest Class - " + getName();
    }
}
