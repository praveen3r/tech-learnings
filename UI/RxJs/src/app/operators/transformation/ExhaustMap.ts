import { of, merge, interval } from 'rxjs';
import { take, delay, exhaustMap } from 'rxjs/operators';

export class ExhaustMap {

    //exhaustMap(project: function, resultSelector: function): Observable

    /* An Observable containing projected Observables of each item of the source, 
    ignoring projected Observables that start before their preceding Observable has completed. 
    
    Maps each value to an Observable, then flattens all of these inner Observables using exhaust.
    
    Returns an Observable that emits items based on applying a function that you supply to 
    each item emitted by the source Observable, where that function returns an (so-called "inner")
     Observable. When it projects a source value to an Observable, the output Observable begins 
     emitting the items emitted by that projected Observable. However, exhaustMap ignores every 
     new projected Observable if the previous projected Observable has not yet completed. 
     Once that one completes, it will accept and flatten the next projected Observable and 
     repeat this process.*/

    static processExhaustMap() {

        const sourceInterval = interval(1000);
        const delayedInterval = sourceInterval.pipe(
            delay(10),
            take(4)
        );

        const exhaustSub = merge(
            // delay 10ms, then start interval emitting 4 values
            delayedInterval,
            // emit immediately
            of(true)
        )
            .pipe(exhaustMap(_ => sourceInterval.pipe(take(5))))
            /*
             *  The first emitted value (of(true)) will be mapped
             *  to an interval observable emitting 1 value every
             *  second, completing after 5.
             *  Because the emissions from the delayed interval
             *  fall while this observable is still active they will be ignored.
             *
             *  Contrast this with concatMap which would queue,
             *  switchMap which would switch to a new inner observable each emission,
             *  and mergeMap which would maintain a new subscription for each emitted value.
             */
            // output: 0, 1, 2, 3, 4
            .subscribe(val => console.log(val));
    }

    //Another exhaustMap with interval
    static processExhaustMap1() {
        const firstInterval = interval(1000).pipe(take(10));
        const secondInterval = interval(1000).pipe(take(2));

        const exhaustSub = firstInterval
            .pipe(
                exhaustMap(f => {
                    console.log(`Emission Corrected of first interval: ${f}`);
                    return secondInterval;
                })
            )
            /*
            When we subscribed to the first interval, it starts to emit a values (starting 0).
            This value is mapped to the second interval which then begins to emit (starting 0).  
            While the second interval is active, values from the first interval are ignored.
            We can see this when firstInterval emits number 3,6, and so on...

            Output:
            Emission of first interval: 0
            0
            1
            Emission of first interval: 3
            0
            1
            Emission of first interval: 6
            0
            1
            Emission of first interval: 9
            0
            1
        */
        .subscribe(s => console.log(s));
    }
}