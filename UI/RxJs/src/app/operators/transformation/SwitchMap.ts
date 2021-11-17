import { from, of, interval, fromEvent, merge, empty, timer } from 'rxjs';
import { map, switchAll, switchMap, delay, filter, mapTo, startWith, scan, takeWhile } from 'rxjs/operators';



export class SwitchMap {

    //switchMap(project: function: Observable, resultSelector: function(outerValue, innerValue, outerIndex, innerIndex): any): Observable

    /*
    An Observable that emits the result of applying the projection function (and the optional 
        deprecated resultSelector) to each item emitted by the source Observable and taking only 
        the values from the most recently projected inner Observable.

    Maps each value to an Observable, then flattens all of these inner Observables.

    Returns an Observable that emits items based on applying a function that you supply to 
    each item emitted by the source Observable, where that function returns an (so-called "inner") 
    Observable. Each time it observes one of these inner Observables, the output Observable begins 
    emitting the items emitted by that inner Observable. When a new inner Observable is emitted, 
    switchMap stops emitting items from the earlier-emitted inner Observable and begins emitting 
    items from the new one. It continues to behave like this for subsequent inner Observables.
    */

    //Restart interval on every click
    static processSwitchMap() {
        fromEvent(document, 'click')
            .pipe(
                // restart counter on every click
                switchMap(() => interval(1000))
            )
            .subscribe(console.log);
    }

    //Countdown timer with pause and resume
    static processSwitchMap1() {
        const COUNTDOWN_SECONDS = 10;

        // elem refs
        const remainingLabel = document.getElementById('remaining');
        const pauseButton = document.getElementById('pause');
        const resumeButton = document.getElementById('resume');

        // streams
        const interval$ = interval(1000).pipe(mapTo(-1));
        const pause$ = fromEvent(pauseButton, 'click').pipe(mapTo(false));
        const resume$ = fromEvent(resumeButton, 'click').pipe(mapTo(true));

        const timer$ = merge(pause$, resume$)
            .pipe(
                startWith(true),
                switchMap(val => (val ? interval$ : empty())),
                scan((acc, curr) => (curr ? curr + acc : acc), COUNTDOWN_SECONDS),
                takeWhile(v => v >= 0)
            )
            .subscribe((val: any) => (remainingLabel.innerHTML = val));
    }

    //Using a resultSelector function
    static processSwitchMap2() {
        // switch to new inner observable when source emits, emit result of project function
        timer(0, 5000)
            .pipe(
                switchMap(
                    _ => interval(2000),
                    (outerValue, innerValue, outerIndex, innerIndex) => ({
                        outerValue,
                        innerValue,
                        outerIndex,
                        innerIndex
                    })
                )
            )
            /*
              Output:
              {outerValue: 0, innerValue: 0, outerIndex: 0, innerIndex: 0}
              {outerValue: 0, innerValue: 1, outerIndex: 0, innerIndex: 1}
              {outerValue: 1, innerValue: 0, outerIndex: 1, innerIndex: 0}
              {outerValue: 1, innerValue: 1, outerIndex: 1, innerIndex: 1}
            */
            .subscribe(console.log);
    }

    static processSwitchMap3() {

        const source = from([1, 2, 3, 4]);
        // using a regular map
        source.pipe(
            map(param => getData(param))
        ).subscribe(val => val.subscribe(data => console.log(data)));

        // using map and switchAll
        source.pipe(
            map(param => getData(param)),
            switchAll()
        ).subscribe(val => console.log(val));

        // using switchMap
        source.pipe(
            switchMap(param => getData(param))
        ).subscribe(val => console.log(val));
    }



    static processSwitchMap4() {

        const source = from([1, 2, 3, 4]);


        // using switchMap
        source.pipe(filter(val => val > 2)).pipe(
            switchMap(param => getData(param))
        ).subscribe(val => console.log(val));
    }

}

const getData = (param) => {
    return of(`retrieved new data with param ${param}`).pipe(
        delay(1000)
    )


}