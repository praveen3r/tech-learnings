package project.IdolCompetition.Performer;

import project.IdolCompetition.Instrument.Instrument;
import project.IdolCompetition.Performer.Performer;

import java.util.Map;

/**
 * Created by ymukhin on 5/11/2017.
 */
public class OneManBand implements Performer {
    public OneManBand() {
    }

    @Override
    public void perform() {
        for (String key : instruments.keySet()) {
            System.out.print(key + " ");
            instruments.get(key).play();
        }
    }

    private Map<String, Instrument> instruments;

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }
}
