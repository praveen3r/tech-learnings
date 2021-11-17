package pureannotations.concepts.autowired.example1;

import org.springframework.stereotype.Component;

@Component
public class Note {
    private Paper paper;

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
