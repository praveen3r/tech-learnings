package project.IdolCompetition.poem;

/**
 * Created by ymukhin on 5/10/2017.
 */
public class Sonnet29 implements Poem {
    private static String[] LINES = {
            "Hello",
            "Im still here"
    };

    public Sonnet29() {
    }

    public void recite() {
        for (String line : LINES) {
            System.out.println(line);
        }
    }

    public void fin() {
        System.out.println("fg");
    }
}
