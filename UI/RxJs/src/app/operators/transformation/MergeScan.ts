import { mergeMap, mergeScan, scan, map, takeUntil, mapTo } from 'rxjs/operators';
import { fromEvent, interval, of } from 'rxjs';

export class MergeScan {

    //mergeScan(accumulator: (acc, value, index: number) => ObservableInput, seed, concurrent: number = Number.POSITIVE_INFINITY): OperatorFunction

    /* An observable of the accumulated values. 
    
    It's like scan, but the Observables returned by the accumulator are merged into the outer Observable.
    
    flatMap is an alias for mergeMap! */


    //Accumulate total duration mouse held down over time
    static processMergeScan() {
        // reference
        const durationElem = document.getElementById('duration');

        // streams
        const mouseDown$ = fromEvent(document, 'mousedown');
        const mouseUp$ = fromEvent(document, 'mouseup');

        // accumulate time mouse held down over time
        mouseDown$
            .pipe(
                mergeScan((acc, curr) => {
                    return interval(1000).pipe(
                        scan((a, _) => ++a, 0),
                        map((val: any) => val + acc),
                        takeUntil(mouseUp$)
                    );
                }, 0)
                // output: 1s...2s...3s...4s...
            )
            .subscribe(val => (durationElem.innerHTML = `${val}s`));
    }

    //Count the number of click events
    static processMergeScan1() {
        const click$ = fromEvent(document, 'click');
        const one$ = click$.pipe(mapTo(1));
        const seed = 0;
        const count$ = one$.pipe(
              mergeScan((acc, one) => of(acc + one), seed),
            );
        count$.subscribe(x => console.log(x));
        
        // Results:
        // 1
        // 2
        // 3
        // 4
        // ...and so on for each click

    }

}

