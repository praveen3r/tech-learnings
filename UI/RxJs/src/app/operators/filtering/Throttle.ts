import { interval } from 'rxjs';
import { throttle } from 'rxjs/operators';

export class Throttle {

    //throttle(durationSelector: function(value): Observable | Promise): Observable 

    /*  An Observable that performs the throttle operation to limit the rate of emissions from the source.

    It's like throttleTime, but the silencing duration is determined by a second Observable.

    throttle emits the source Observable values on the output Observable when its internal timer 
    is disabled, and ignores source values when the timer is enabled. Initially, the timer is disabled.
    As soon as the first source value arrives, it is forwarded to the output Observable, and then 
    the timer is enabled by calling the durationSelector function with the source value,
    which returns the "duration" Observable. When the duration Observable emits a value or completes, 
    the timer is disabled, and this process repeats for the next source value.
    */
   
    static processThrottle() {
        //emit value every 1 second
        const source = interval(1000);

        //throttle for 2 seconds, emit latest value
        const example = source.pipe(throttle(val => interval(2000)));

        //output: 0...3...6...9
        const subscribe = example.subscribe(val => console.log(val));

    }
}