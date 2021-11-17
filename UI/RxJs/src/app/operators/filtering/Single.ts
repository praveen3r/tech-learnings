import { from, range } from 'rxjs';
import { first, single } from 'rxjs/operators';

export class Single {

    // single(a: Function): Observable

    /* An Observable that emits the single item emitted by the source Observable that matches 
        the predicate or undefined when no items match.

    Throws
        EmptyError Delivers an EmptyError to the Observer's error callback if the Observable completes 
        before any next notification was sent.

    Like first, but emit with error notification if there is more than one value.
    */

    //Emit first number passing predicate
    static processSingle() {

        //emit (1,2,3,4,5)
        const source = from([1, 2, 3, 4, 5]);
        //emit one item that matches predicate
        const example = source.pipe(single(val => val === 4));
        //output: 4
        const subscribe = example.subscribe(val => console.log(val));

    }

    //emits 'error'
    static processSingle1() {

        const numbers = range(1, 5).pipe(single());
        numbers.subscribe(x => console.log('never get called'), e => console.log('error'));
        // result
        // 'error'


    }

    // emits 'undefined'
    static processSingle2() {

        const numbers = range(1, 5).pipe(single(x => x === 10));
        numbers.subscribe(x => console.log(x));
        // result
        // 'undefined'

    }
}