import { take, takeLast, takeUntil, withLatestFrom, map, filter, scan, takeWhile } from 'rxjs/operators';
import { of, interval, timer } from 'rxjs';

export class TakeWhile {

    //takeWhile(predicate: function(value, index): boolean, inclusive?: boolean): Observable

    /* 
    An Observable that emits the values from the source Observable so long as each value satisfies the 
    condition defined by the predicate, then completes.

    Takes values from the source only while they pass the condition given. When the first value 
    does not satisfy, it completes.

    takeWhile subscribes and begins mirroring the source Observable. Each value emitted on the 
    source is given to the predicate function which returns a boolean, representing a condition 
    to be satisfied by the source values. The output Observable emits the source values until 
    such time as the predicate returns false, at which point takeWhile stops mirroring the source 
    Observable and completes the output Observable.
    */

    static processTakeWhile() {

        //emit 1,2,3,4,5
        const source$ = of(1, 2, 3, 4, 5);

        //allow values until value from source is greater than 4, then complete
        source$
            .pipe(takeWhile(val => val <= 4))
            // log: 1,2,3,4
            .subscribe(val => console.log(val));


    }

    // takeWhile with inclusive flag
    static processTakeWhile1() {
        const source$ = of(1, 2, 3, 9);

        source$
            // with inclusive flag, the value causing the predicate to return false will also be emitted
            .pipe(takeWhile(val => val <= 3, true))
            // log: 1, 2, 3, 9
            .subscribe(console.log);
    }

    static processTakeWhile2() {
        // emit 3, 3, 3, 9, 1, 4, 5, 8, 96, 3, 66, 3, 3, 3
        const source$ = of(3, 3, 3, 9, 1, 4, 5, 8, 96, 3, 66, 3, 3, 3);

        // allow values until value from source equals 3, then complete
        source$
            .pipe(takeWhile(it => it === 3))
            // log: 3, 3, 3
            .subscribe(val => console.log('takeWhile', val));

        source$
            .pipe(filter(it => it === 3))
            // log: 3, 3, 3, 3, 3, 3, 3
            .subscribe(val => console.log('filter', val));
    }

}