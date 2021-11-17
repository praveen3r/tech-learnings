import { fromEvent, of, merge } from 'rxjs';
import { mergeMap, delay, takeUntil, mapTo } from 'rxjs/operators';

export class Delay {

    //delay(delay: number | Date, scheduler: Scheduler): Observable

    /* An Observable that delays the emissions of the source Observable by the specified timeout or Date.

    Time shifts each item by some specified amount of milliseconds.

    If the delay argument is a Number, this operator time shifts the source Observable by that 
    amount of time expressed in milliseconds. The relative time intervals between the values are 
    preserved.

    If the delay argument is a Date, this operator time shifts the start of the Observable execution
     until the given date occurs.

    */

    //Delay to recognize long press
    static processDelay() {
        const mousedown$ = fromEvent(document, 'mousedown');
        const mouseup$ = fromEvent(document, 'mouseup');

        mousedown$
            .pipe(mergeMap(event => of(event).pipe(delay(700), takeUntil(mouseup$))))
            .subscribe(event => console.log('Long Press!', event));
    }

    //Delay for increasing durations
    static processDelay1() {
        //emit one item
        const example = of(null);
        //delay output of each by an extra second
        const message = merge(
            example.pipe(mapTo('Hello')),
            example.pipe(mapTo('World!'), delay(1000)),
            example.pipe(mapTo('Goodbye'), delay(2000)),
            example.pipe(mapTo('World!'), delay(3000))
        );
        //output: 'Hello'...'World!'...'Goodbye'...'World!'
        const subscribe = message.subscribe(val => console.log(val));
    }
}