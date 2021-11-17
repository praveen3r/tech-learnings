import { fromEvent, interval } from 'rxjs';
import { timeInterval, tap } from 'rxjs/operators';

export class TimeInterval {

    //Observable that emit infomation about value and interval

    /* Convert an Observable that emits items into one that emits indications of the amount of time 
        elapsed between those emissions.

    */

    //Emit inteval between current value with the last value
    static processTimeInterval() {
        const seconds = interval(1000);

        seconds.pipe(timeInterval()).
            subscribe(
                value => console.log(value),
                err => console.log(err),
            );

    }

    //Time between mouse clicks
    static processTimeInterval1() {
        fromEvent(document, 'mousedown')
            .pipe(
                timeInterval(),
                tap(console.log)
            )
            .subscribe(
                i =>
                    (document.body.innerText = `milliseconds since last click: ${i.interval}`)
            );
    }
}