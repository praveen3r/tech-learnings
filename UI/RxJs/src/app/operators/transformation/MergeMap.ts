import { Observable, of, from, fromEvent, interval } from 'rxjs';
import { mergeMap, map, delay, mergeAll, take } from 'rxjs/operators';

export class MergeMap {

    //mergeMap(project: function: Observable, resultSelector: function: any, concurrent: number): Observable 

    /* An Observable that emits the result of applying the projection function 
    (and the optional deprecated resultSelector) to each item emitted by the source Observable 
    and merging the results of the Observables obtained from this transformation. 
    
    Maps each value to an Observable, then flattens all of these inner Observables using mergeAll.
    
    flatMap is an alias for mergeMap! */


    //mergeMap simulating save of click locations
    static processMergeMap() {
        // faking network request for save
        const saveLocation = location => {
            return of(location).pipe(delay(500));
        };
        // streams
        const click$ = fromEvent(document, 'click');

        click$
            .pipe(
                mergeMap((e: MouseEvent) => {
                    return saveLocation({
                        x: e.clientX,
                        y: e.clientY,
                        timestamp: Date.now()
                    });
                })
            )
            // Saved! {x: 98, y: 170, ...}
            .subscribe(r => console.log('Saved!', r));
    }

    //mergeMap with resultSelector
    static processMergeMap1() {

        // helper to create promise
        const myPromise = val =>
            new Promise(resolve => resolve(`${val} World From Promise!`));

        // emit 'Hello'
        const source$ = of('Hello');

        source$
            .pipe(
                mergeMap(
                    val => myPromise(val),
                    /*
                    you can also supply a second argument which receives the source value and emitted
                    value of inner observable or promise
                  */
                    (valueFromSource, valueFromPromise) => {
                        return `Source: ${valueFromSource}, Promise: ${valueFromPromise}`;
                    }
                )
            )
            // output: "Source: Hello, Promise: Hello World From Promise!"
            .subscribe(val => console.log(val));
    }

    //mergeMap with concurrent value
    static processMergeMap2() {
        // emit value every 1s
        const source$ = interval(1000);

        source$
            .pipe(
                mergeMap(
                    // project
                    val => interval(5000).pipe(take(2)),
                    // resultSelector
                    (oVal, iVal, oIndex, iIndex) => [oIndex, oVal, iIndex, iVal],
                    // concurrent
                    2
                )
            )
            /*
                  Output:
                  [0, 0, 0, 0] <--1st inner observable
                  [1, 1, 0, 0] <--2nd inner observable
                  [0, 0, 1, 1] <--1st inner observable
                  [1, 1, 1, 1] <--2nd inner observable
                  [2, 2, 0, 0] <--3rd inner observable
                  [3, 3, 0, 0] <--4th inner observable
          */
            .subscribe(val => console.log(val));
    }

    static processMergeMap3() {

        const source1: Observable<number> = of(1, 2, 3);
        const source2 = of(4);

        // map value from source into inner observable, when complete emit result and move to next
        const example1 = source1.pipe(mergeMap(val => source2));

        //output: 5, 6, 7
        example1.subscribe(val => console.log(`With mergeMap : ${val}`));

    }

    static processMergeMap4() {

        const source = from([1, 2, 3, 4]);
        // using a regular map
        source.pipe(
            map(param => getData(param))
        ).subscribe(val => val.subscribe(data => console.log(data)));

        // using map and mergeAll
        source.pipe(
            map(param => getData(param)),
            mergeAll()
        ).subscribe(val => console.log(val));

        // using mergeMap
        source.pipe(
            mergeMap(param => getData(param))
        ).subscribe(val => console.log(val));
    }

}

const getData = (param) => {
    return of(`retrieved new data with param ${param}`).pipe(
        delay(1000)
    )
}