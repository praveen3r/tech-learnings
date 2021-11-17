import { of } from 'rxjs';
import { delay, repeat } from 'rxjs/operators';

export class Repeat {

    //An Observable that will resubscribe to the source stream when the source stream completes , at most count times.

    /* Repeats all values emitted on the source. It's like retry, but for non error cases.
    
    Similar to retry, this operator repeats the stream of items emitted by the source for non error
     cases. Repeat can be useful for creating observables that are meant to have some repeated 
     pattern or rhythm.

    Note: repeat(0) returns an empty observable and repeat() will repeat forever
    */

    static processRepeat() {
        const delayedThing = of('delayed value').pipe(delay(2000));

        delayedThing
            .pipe(repeat(3))
            // delayed value...delayed value...delayed value
            .subscribe(console.log);
    }
}