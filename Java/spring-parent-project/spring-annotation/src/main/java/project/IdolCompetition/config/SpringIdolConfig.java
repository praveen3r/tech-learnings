package project.IdolCompetition.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.IdolCompetition.Performer.Instrumentalist;
import project.IdolCompetition.Performer.Juggler;
import project.IdolCompetition.Performer.Performer;
import project.IdolCompetition.Performer.PoeticJuggler;
import project.IdolCompetition.poem.Poem;
import project.IdolCompetition.poem.Sonnet29;

/**
 * Created by ymukhin on 8/16/2017.
 */
@Configuration
public class SpringIdolConfig {

    @Bean
    public Performer duke() {
        return new Juggler();
    }

    @Bean
    public Performer duke15() {
        return new Juggler(15);
    }

    @Bean
    public Performer kenny() {
        Instrumentalist kenny = new Instrumentalist();
        kenny.setSong("Jingle Bells");
        return kenny;
    }

    @Bean
    public Poem sonnet29() {
        return new Sonnet29();
    }

    @Bean
    public Performer poeticDuke() {
        return new PoeticJuggler(sonnet29());
    }
}
