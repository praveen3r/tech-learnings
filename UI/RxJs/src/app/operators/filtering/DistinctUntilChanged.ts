import { from } from 'rxjs';
import { distinctUntilChanged } from 'rxjs/operators';


export class DistinctUntilChanged {

    //distinctUntilChanged(compare: function): Observable 

    /* An Observable that emits items from the source Observable with distinct values
    
    If a comparator function is provided, then it will be called for each item to test for 
    whether or not that value should be emitted.

    If a comparator function is not provided, an equality check is used by default.
    */

    static processDistinctUntilChanged() {

        // only output distinct values, based on the last emitted value
        const source$ = from([1, 1, 2, 2, 3, 3]);

        // output: 1,2,3
        source$
            .pipe(distinctUntilChanged())
            .subscribe(console.log);

    }

    static processDistinctUntilChanged1() {

        // only output distinct values, based on the last emitted value
        const source$ = from([
            { age: 4, name: 'Foo' },
            { age: 7, name: 'Bar' },
            { age: 5, name: 'Foo' },
            { age: 6, name: 'Foo' },
        ]);


        // custom compare for name
        source$
            .pipe(distinctUntilChanged((prev, curr) => prev.name === curr.name))
            .subscribe(console.log);


    }
}