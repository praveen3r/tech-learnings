package project.IdolCompetition.location;

/**
 * Created by ymukhin on 5/11/2017.
 */
public class Stage {
    private static Stage ourInstance = new Stage();

    public static Stage getInstance() {
        return ourInstance;
    }

    private Stage() {
    }
}
