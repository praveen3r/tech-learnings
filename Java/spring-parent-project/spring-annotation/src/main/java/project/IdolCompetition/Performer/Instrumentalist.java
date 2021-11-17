package project.IdolCompetition.Performer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import project.IdolCompetition.Instrument.Instrument;
import project.IdolCompetition.Instrument.StringedInstrument;
import project.IdolCompetition.Instrument.Strummed;


/**
 * Created by ymukhin on 5/11/2017.
 */
@Component("eddie")
public
class Instrumentalist implements Performer {
    public Instrumentalist() {
    }

    @Override
    public void perform() {
        instrument.play();
        System.out.println(this.song);
        System.out.println("Instrument");
    }

    @Value("My" + " song")
    private String song;

    public void setSong(String song) {
        this.song = song;
    }

    public String screamSong() {
        return song;
    }


    @Autowired
    @StringedInstrument
    @Strummed
    //@Qualifier("guitar")
    private Instrument instrument;
    /*
        @Autowired
        public void setInstrument(IdolCompetition.Instrument instrument) {
            System.out.println("Hello");
            this.instrument = instrument;
        }*/
}