import { take, takeLast, takeUntil, withLatestFrom, map, filter, scan } from 'rxjs/operators';
import { of, interval, timer } from 'rxjs';

export class TakeUntil {

    //takeUntil(notifier: Observable): Observable

    /* 
    An Observable that emits the values from the source Observable until such time as 
    notifier emits its first value.

    Lets values pass until a second Observable, notifier, emits a value. Then, it completes.

    takeUntil subscribes and begins mirroring the source Observable. It also monitors a second Observable, 
    notifier that you provide. If the notifier emits a value, the output Observable stops mirroring 
    the source Observable and completes. If the notifier doesn't emit any value and completes then 
    takeUntil will pass all values.
    */

    static processTakeUntil() {

        //emit value every 1s
        const source = interval(1000);
        //after 5 seconds, emit value
        const timer$ = timer(5000);
        //when timer emits after 5s, complete source
        const example = source.pipe(takeUntil(timer$));
        //output: 0,1,2,3
        const subscribe = example.subscribe(val => console.log(val));


    }

    // Take the first 5 even numbers
    static processTakeUntil1() {
        //emit value every 1s
        const source = interval(1000);
        //is number even?
        const isEven = val => val % 2 === 0;
        //only allow values that are even
        const evenSource = source.pipe(filter(isEven));
        //keep a running total of the number of even numbers out
        const evenNumberCount = evenSource.pipe(scan((acc, _) => acc + 1, 0));
        //do not emit until 5 even numbers have been emitted
        const fiveEvenNumbers = evenNumberCount.pipe(filter(val => val > 5));

        const example = evenSource.pipe(
            //also give me the current even number count for display
            withLatestFrom(evenNumberCount),
            map(([val, count]) => `Even number (${count}) : ${val}`),
            //when five even numbers have been emitted, complete source observable
            takeUntil(fiveEvenNumbers)
        );
        /*
            Even number (1) : 0,
          Even number (2) : 2
            Even number (3) : 4
            Even number (4) : 6
            Even number (5) : 8
        */
        const subscribe = example.subscribe(val => console.log(val));
    }

}