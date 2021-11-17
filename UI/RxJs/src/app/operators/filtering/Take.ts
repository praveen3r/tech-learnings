import { take } from 'rxjs/operators';
import { of, interval } from 'rxjs';

export class Take {

    //take(count: number): Observable 

    /* 
    An Observable that emits only the first count values emitted by the source Observable, 
    or all of the values from the source if the source emits fewer than count values.

    When using take(i), it delivers an ArgumentOutOrRangeError to the Observer's error 
    callback if i < 0.

    Takes the first count values from the source, then completes.
    */
    static processTake() {

        //emit 1,2,3,4,5
        const source = of(1, 2, 3, 4, 5);
        //take the first emitted value then complete
        const example = source.pipe(take(1));
        //output: 1
        const subscribe = example.subscribe(val => console.log(val));


    }

    static processTake1() {

        //emit value every 1s
        const interval$ = interval(1000);
        //take the first 5 emitted values
        const example = interval$.pipe(take(5));
        //output: 0,1,2,3,4
        const subscribe = example.subscribe(val => console.log(val));



    }
}