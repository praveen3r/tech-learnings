package project.IdolCompetition.Performer;

import project.IdolCompetition.poem.Poem;

/**
 * Created by ymukhin on 5/10/2017.
 */
public class PoeticJuggler extends Juggler {
    private Poem poem;

    public PoeticJuggler(Poem poem) {
        super();
        this.poem = poem;
    }

    public PoeticJuggler(int beanflags, Poem poem) {
        super(beanflags);
        this.poem = poem;
    }

    @Override
    public void perform() {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }


}
