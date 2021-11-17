import { take, takeLast } from 'rxjs/operators';
import { of, interval } from 'rxjs';

export class TakeLast {

    //takeLast(count: number): Observable

    /* 
    An Observable that emits at most the last count values emitted by the source Observable.

    When using takeLast(i), it delivers an ArgumentOutOrRangeError to the Observer's error 
    callback if i < 0.

    takeLast returns an Observable that emits at most the last count values emitted by the source 
    Observable. If the source emits fewer than count values then all of its values are emitted. 
    This operator must wait until the complete notification emission from the source in order to 
    emit the next values on the output Observable, because otherwise it is impossible to know 
    whether or not more values will be emitted on the source. For this reason, all values are 
    emitted synchronously, followed by the complete notification
    */
    static processTakeLast() {

        const source = of('Ignore', 'Ignore', 'Hello', 'World!');
        // take the last 2 emitted values
        const example = source.pipe(takeLast(2));
        // Hello, World!
        const subscribe = example.subscribe(val => console.log(val));


    }

}