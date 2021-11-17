import { from } from 'rxjs';
import { last } from 'rxjs/operators';

export class Last {

    // last(predicate: function): Observable

    /* An Observable that emits only the last item satisfying the given condition from the source, 
        or an NoSuchElementException if no such items are emitted.

    Throws
        EmptyError Delivers an EmptyError to the Observer's error callback if the Observable completes 
        before any next notification was sent.

        Error - Throws if no items that match the predicate are emitted by the source Observable.

      */

    //Last value in sequence
    static processLast() {

        const source = from([1, 2, 3, 4, 5]);
        //no arguments, emit last value
        const example = source.pipe(last());
        //output: "Last value: 5"
        const subscribe = example.subscribe(val => console.log(`Last value: ${val}`));

    }

    //Last  value to pass predicate
    static processLast1() {

        const source = from([1, 2, 3, 4, 5]);

        //emit first item to pass test
        const example = source.pipe(last(num => num % 2 === 0));

        //output: "Last to pass test: 4"
        const subscribe = example.subscribe(val =>
            console.log(`Last to pass test: ${val}`)
        );


    }

    // Last with default value
    static processLast2() {

        const source = from([1, 2, 3, 4, 5]);
        //no values will pass given predicate, emit default
        const exampleTwo = source.pipe(last(v => v > 5, 'Nothing!'));
        //output: 'Nothing!'
        const subscribeTwo = exampleTwo.subscribe(val => console.log(val));

    }
}