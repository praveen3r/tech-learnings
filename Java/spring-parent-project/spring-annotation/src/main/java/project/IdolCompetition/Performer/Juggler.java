package project.IdolCompetition.Performer;

import project.IdolCompetition.Performer.Performer;

/**
 * Created by ymukhin on 5/10/2017.
 */
public class Juggler implements Performer {

    private int beanflags = 3;

    public Juggler() {
    }

    public Juggler(int beanflags) {
        this.beanflags = beanflags;
    }

    @Override
    public void perform() {
        System.out.println("Jggling " + beanflags);
    }
}
