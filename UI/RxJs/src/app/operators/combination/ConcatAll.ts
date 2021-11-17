import { interval, of } from 'rxjs';
import { map, concatAll, take } from 'rxjs/operators';

export class ConcatAll {
    // An Observable emitting values from all the inner Observables

    /*
    Joins every Observable emitted by the source (a higher-order Observable), in a serial fashion. It subscribes to each inner Observable only after the previous inner Observable has completed, and merges all of their values into the returned observable.

Warning: If the source Observable emits Observables quickly and endlessly, and the inner Observables it emits generally complete slower than the source emits, you can run into memory issues as the incoming Observables collect in an unbounded buffer.

Note: concatAll is equivalent to mergeAll with concurrency parameter set to 1.

    */
    static processCombineLatest() {
        //emit a value every 2 seconds
        const source = interval(2000);
        const example = source.pipe(
            //for demonstration, add 10 to and return as observable
            map(val => of(val + 10)),
            //merge values from inner observable
            concatAll()
        );
        //output: 'Example with Basic Observable 10', 'Example with Basic Observable 11'...
        const subscribe = example.subscribe(val =>
            console.log('Example with Basic Observable:', val)
        );
    }

    static processCombineLatest1() {
        const obs1 = interval(1000).pipe(take(5));
        const obs2 = interval(500).pipe(take(2));
        const obs3 = interval(2000).pipe(take(1));
        //emit three observables
        const source = of(obs1, obs2, obs3);
        //subscribe to each inner observable in order when previous completes
        const example = source.pipe(concatAll());
        /*
          output: 0,1,2,3,4,0,1,0
          How it works...
          Subscribes to each inner observable and emit values, when complete subscribe to next
          obs1: 0,1,2,3,4 (complete)
          obs2: 0,1 (complete)
          obs3: 0 (complete)
        */

        const subscribe = example.subscribe(val => console.log(val));
    }
}