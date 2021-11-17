import { of, from } from 'rxjs';
import { distinct } from 'rxjs/operators';

export class Distinct {

    //distinct(keySelector?, flushes?): Observable

    /* An Observable that emits items from the source Observable with distinct values.

        If a keySelector function is provided, then it will project each value from the source observable into a new value that it will check for equality with previously projected values. If a keySelector function is not provided, it will use each value from the source observable directly with an equality check against previous values.

In JavaScript runtimes that support Set, this operator will use a Set to improve performance of the distinct value checking.

In other runtimes, this operator will use a minimal implementation of Set that relies on an 
Array and indexOf under the hood, so performance will degrade as more values are checked for distinction.
Even in newer browsers, a long-running distinct use might result in memory leaks. To help alleviate
this in some scenarios, an optional flushes parameter is also provided so that the internal Set can be 
"flushed", basically clearing it of values.

*/


    static processDistinct() {
        of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
            .pipe(distinct())
            // OUTPUT: 1,2,3,4,5
            .subscribe(console.log);
    }

    static processDistinct1() {
        const obj1 = { id: 3, name: 'name 1' };
        const obj2 = { id: 4, name: 'name 2' };
        const obj3 = { id: 3, name: 'name 3' };
        const vals = [obj1, obj2, obj3];

        from(vals)
            .pipe(distinct(e => e.id))
            .subscribe(console.log);

        /*
        OUTPUT:
        {id: 3, name: "name 1"}
        {id: 4, name: "name 2"}
         */
    }
}