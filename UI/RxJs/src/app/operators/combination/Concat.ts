import { of, Observable, concat } from 'rxjs';
import { } from 'rxjs';

export class Concat {


    //concat(observables: ...*): Observable 

    /* All values of each passed Observable merged into a single Observable, in order, in serial fashion.
    Concatenates multiple Observables together by sequentially emitting their values, one Observable 
    after the other.
    
    Note that if some input Observable never completes, concat will also never complete and Observables 
    following the one that did not complete will never be subscribed. 
    
    If any Observable in chain errors, instead of passing control to the next Observable, concat will
     error immediately as well. Observables that would be subscribed after the one that emitted error,
      never will. */

    static processConcat() {

        const source1: Observable<number> = of(1, 2, 3);
        const source2: Observable<number> = of(4, 5, 6);
        const source3: Observable<number> = of(7, 8, 9);
        const result = concat(source1, source2, source3);
        result.subscribe(console.log);

    }

    static processConcatSame() {

        const source1: Observable<number> = of(1, 2, 3);
        const result = concat(source1, source1);
        result.subscribe(console.log);

    }
}