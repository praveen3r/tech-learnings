import { interval } from 'rxjs';
import { withLatestFrom, map } from 'rxjs/operators';

export class WithLatestFrom {

    //withLatestFrom(other: Observable, project: Function): Observable 

    /* 
    An Observable of projected values from the most recent values from each input Observable, 
    or an array of the most recent values from each input Observable.

    Whenever the source Observable emits a value, it computes a formula using that value plus the 
    latest values from other input Observables, then emits the output of that formula.

    withLatestFrom combines each value from the source Observable (the instance) with the latest 
    values from the other input Observables only when the source emits a value, optionally using a 
    project function to determine the value to be emitted on the output Observable. All input 
    Observables must emit at least one value before the output Observable will emit a value.
    */

    //Latest value from quicker second source
    static processWithLatestFrom() {

        //emit every 5s
        const source = interval(5000);

        //emit every 1s
        const secondSource = interval(1000);

        const example = source.pipe(
            withLatestFrom(secondSource),
            map(([first, second]) => {
                return `First Source (5s): ${first} Second Source (1s): ${second}`;
            })
        );

        /*
          "First Source (5s): 0 Second Source (1s): 4"
          "First Source (5s): 1 Second Source (1s): 9"
          "First Source (5s): 2 Second Source (1s): 14"
          ...
        */

        const subscribe = example.subscribe(val => console.log(val));


    }

    //Slower second source
    static processWithLatestFrom1() {

        //emit every 5s
        const source = interval(5000);
        //emit every 1s
        const secondSource = interval(1000);
        //withLatestFrom slower than source
        const example = secondSource.pipe(
            //both sources must emit at least 1 value (5s) before emitting
            withLatestFrom(source),
            map(([first, second]) => {
                return `Source (1s): ${first} Latest From (5s): ${second}`;
            })
        );
        /*
          "Source (1s): 4 Latest From (5s): 0"
          "Source (1s): 5 Latest From (5s): 0"
          "Source (1s): 6 Latest From (5s): 0"
          ...
        */
        const subscribe = example.subscribe(val => console.log(val));

    }
}