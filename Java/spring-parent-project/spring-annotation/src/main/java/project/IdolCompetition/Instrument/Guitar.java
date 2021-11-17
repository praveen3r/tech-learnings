package project.IdolCompetition.Instrument;

import org.springframework.stereotype.Component;

/**
 * Created by ymukhin on 8/2/2017.
 */

@Component
@StringedInstrument
@Strummed
public class Guitar implements Instrument {

    public Guitar() {

    }

    @Override
    public void play() {
        System.out.println("guitar");
    }
}
