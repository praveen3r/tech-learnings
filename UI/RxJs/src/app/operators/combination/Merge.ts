import { interval, merge } from 'rxjs';
import { mapTo } from 'rxjs/operators';

export class Merge {

    //merge<T, R>(...observables: any[]): Observable<R>

    /* an Observable that emits items that are the result of every input Observable
    
    Flattens multiple Observables together by blending their values into one Observable.
    
    merge subscribes to each given input Observable (as arguments), and simply forwards 
    (without doing any transformation) all the values from all the input Observables to the 
    output Observable. The output Observable only completes once all input Observables have completed. 
    Any error delivered by an input Observable will be immediately emitted on the output Observable.*/

    static processMerge() {

        //emit every 2.5 seconds
        const first = interval(2500);
        //emit every 2 seconds
        const second = interval(2000);
        //emit every 1.5 seconds
        const third = interval(1500);
        //emit every 1 second
        const fourth = interval(1000);

        //emit outputs from one observable
        const example = merge(
            first.pipe(mapTo('FIRST!')),
            second.pipe(mapTo('SECOND!')),
            third.pipe(mapTo('THIRD')),
            fourth.pipe(mapTo('FOURTH'))
        );
        //output: "FOURTH", "THIRD", "SECOND!", "FOURTH", "FIRST!", "THIRD", "FOURTH"
        const subscribe = example.subscribe(val => console.log(val));

    }

    static processMerge1() {
        //emit every 2.5 seconds
        const first = interval(2500);
        //emit every 1 second
        const second = interval(1000);
        //used as instance method
       // const example = first.pipe(merge(second));
        //output: 0,1,0,2....
        //const subscribe = example.subscribe(val => console.log(val));

    }
}