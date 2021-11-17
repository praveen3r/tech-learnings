import { startWith, scan } from 'rxjs/operators';
import { of, interval } from 'rxjs';

export class StartWith {

    // startWith(an: Values): Observable 

    /* An Observable that emits the items in the specified Iterable and then emits the
     items emitted by the source Observable.

     First emits its arguments in order, and then any emissions from the source.
     */

    static processStartWith() {

        //emit (1,2,3)
        const source = of(1, 2, 3);

        //start with 0
        const example = source.pipe(startWith(0));

        //output: 0,1,2,3
        const subscribe = example.subscribe(val => console.log(val));

    }

    static processStartWith1() {
        //emit ('World!', 'Goodbye', 'World!')
        const source = of('World!', 'Goodbye', 'World!');

        //start with 'Hello', concat current string to previous
        const example = source.pipe(
            startWith('Hello'),
            scan((acc, curr) => `${acc} ${curr}`)
        );

        /*
          output:
          "Hello"
          "Hello World!"
          "Hello World! Goodbye"
          "Hello World! Goodbye World!"
        */
        const subscribe = example.subscribe(val => console.log(val));

    }

    static processStartWith2() {
        //emit values in sequence every 1s
        const source = interval(1000);

        //start with -3, -2, -1
        const example = source.pipe(startWith(-3, -2, -1));
        
        //output: -3, -2, -1, 0, 1, 2....
        const subscribe = example.subscribe(val => console.log(val));

    }
}