import { map, mergeAll } from 'rxjs/operators';
import { of } from 'rxjs';

export class MergeAll {

    //An Observable that emits values coming from all the inner Observables emitted by the source Observable.

    /* mergeAll subscribes to an Observable that emits Observables, also known as a higher-order 
    Observable. Each time it observes one of these emitted inner Observables, it subscribes to 
    that and delivers all the values from the inner Observable on the output Observable. 
    The output Observable only completes once all inner Observables have completed. Any error 
    delivered by a inner Observable will be immediately emitted on the output Observable.*/

    static processMergeAll() {

        const myPromise = val =>
            new Promise(resolve => setTimeout(() => resolve(`Result: ${val}`), 2000));
        //emit 1,2,3
        const source = of(1, 2, 3);

        const example = source.pipe(
            //map each value to promise
            map(val => myPromise(val)),
            //emit result from source
            mergeAll()
        );

        /*
          output:
          "Result: 1"
          "Result: 2"
          "Result: 3"
        */
        const subscribe = example.subscribe(val => console.log(val));

    }

    static processMergeAll1() {
    }
}