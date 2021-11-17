import { of, empty, fromEvent, interval } from 'rxjs';
import { defaultIfEmpty, takeUntil } from 'rxjs/operators';

export class DefaultIfEmpty {
    // defaultIfEmpty(defaultValue: any): Observable

    /*
    An Observable that emits either the specified defaultValue if the source Observable emits
     no items, or the values emitted by the source Observable.

    */

    //Default for empty value
    static processDefaultIfEmpty() {
        //emit 'Observable.of() Empty!' when empty, else any values from source
        const exampleOne = of().pipe(defaultIfEmpty('Observable.of() Empty!'));
        //output: 'Observable.of() Empty!'
        const subscribe = exampleOne.subscribe(val => console.log(val));
    }

    //Default for Observable.empty
    static processDefaultIfEmpty1() {
        //emit 'Observable.empty()!' when empty, else any values from source
        const example = empty().pipe(defaultIfEmpty('Observable.empty()!'));
        //output: 'Observable.empty()!'
        const subscribe = example.subscribe(val => console.log(val));
    }

    //If no clicks happen in 5 seconds, then emit "no clicks"
    static processDefaultIfEmpty2() {
        const clicks = fromEvent(document, 'click');
        const clicksBeforeFive = clicks.pipe(takeUntil(interval(5000)));
        //const result = clicksBeforeFive.pipe(defaultIfEmpty('no clicks'));
        //result.subscribe(x => console.log(x));
    }
}