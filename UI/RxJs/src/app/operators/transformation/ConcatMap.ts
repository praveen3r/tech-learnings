import { of, Observable, from } from 'rxjs';
import { concatMap, map, delay, mergeMap } from 'rxjs/operators';

export class ConcatMap {


    //concatMap(project: function, resultSelector: function): Observable 

    /* An Observable that emits the result of applying the projection function 
    (and the optional deprecated resultSelector) to each item emitted by the source Observable and 
    taking values from each projected inner Observable sequentially 
    
    Maps each value to an Observable, then flattens all of these inner Observables using concatAll.
    
    Returns an Observable that emits items based on applying a function that you supply to each item 
    emitted by the source Observable, where that function returns an (so-called "inner") Observable. 
    Each new inner Observable is concatenated with the previous inner Observable.

    Warning: if source values arrive endlessly and faster than their corresponding inner Observables 
    can complete, it will result in memory issues as inner Observables amass in an unbounded buffer 
    waiting for their turn to be subscribed to.

    Note: concatMap is equivalent to mergeMap with concurrency parameter set to 1.
    */

    static processConcatMap() {

        const source1: Observable<number> = of(1, 2, 3);
        const source2: Observable<number> = of(4);

        // map value from source into inner observable, when complete emit result and move to next
        const example1 = source1.pipe(concatMap(val => source2));

        //output: 4, 4, 4
        example1.subscribe(val => console.log(`With concatMap: ${val}`));

    }

    //Demonstrating the difference between concatMap and mergeMap
    static processConcatMap1() {

        //emit delay value
        const source = of(2000, 1000);
        // map value from source into inner observable, when complete emit result and move to next
        const example = source.pipe(
            concatMap(val => of(`Delayed by: ${val}ms`).pipe(delay(val)))
        );
        //output: With concatMap: Delayed by: 2000ms, With concatMap: Delayed by: 1000ms
        const subscribe = example.subscribe(val =>
            console.log(`With concatMap: ${val}`)
        );

        // showing the difference between concatMap and mergeMap
        const mergeMapExample = source
            .pipe(
                // just so we can log this after the first example has run
                delay(5000),
                mergeMap(val => of(`Delayed by: ${val}ms`).pipe(delay(val)))
            )
            .subscribe(val => console.log(`With mergeMap: ${val}`));


    }

    //Supplying a projection function
    static processConcatMap2() {
        //emit 'Hello' and 'Goodbye'
        const source = of('Hello', 'Goodbye');
        //example with promise
        const examplePromise = val => new Promise(resolve => resolve(`${val} World!`));
        //result of first param passed to second param selector function before being  returned
        const example = source.pipe(
            concatMap(val => examplePromise(val), result => `${result} w/ selector!`)
        );
        //output: 'Example w/ Selector: 'Hello w/ Selector', Example w/ Selector: 'Goodbye w/ Selector'
        const subscribe = example.subscribe(val =>
            console.log('Example w/ Selector:', val)
        );
    }

    static processConcatMap3() {

        // using a regular map
        from([1, 2, 3, 4]).pipe(
            map(param => getData(param))
        ).subscribe(val => val.subscribe(data => console.log('map:', data)));


        // using concatMap
        from([1, 2, 3, 4]).pipe(
            concatMap(param => getData(param))
        ).subscribe(val => console.log('concatMap:', val));

        /* you can see that the map and mergeMap operators will log whatever value comes back and don’t 
        follow the original order.
         On the other hand the concatMap logs the values in the same value as they were started.*/

    }


}

const getData = (param) => {
    const delayTime = Math.floor(Math.random() * 10000) + 1;
    return of(`retrieved new data with params: ${param} and delay: ${delayTime}`).pipe(
        delay(delayTime)
    )
}