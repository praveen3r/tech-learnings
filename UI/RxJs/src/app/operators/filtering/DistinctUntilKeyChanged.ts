import { from, fromEvent, of } from 'rxjs';
import { distinctUntilChanged, distinctUntilKeyChanged, pluck } from 'rxjs/operators';


export class DistinctUntilKeyChanged {

    //distinctUntilKeyChanged(key, compare: fn): Observable

    /* An Observable that emits items from the source Observable with distinct values based on the 
        key specified.
    
    If a comparator function is provided, then it will be called for each item to test for 
    whether or not that value should be emitted.

    If a comparator function is not provided, an equality check is used by default.
    */

    static processDistinctUntilKeyChanged() {

        // only output distinct values, based on the last emitted value
        const source$ = from([
            { name: 'Brian' },
            { name: 'Joe' },
            { name: 'Joe' },
            { name: 'Sue' }
        ]);

        source$
            // custom compare based on name property
            .pipe(distinctUntilKeyChanged('name'))
            // output: { name: 'Brian }, { name: 'Joe' }, { name: 'Sue' }
            .subscribe(console.log);

    }

    //Keyboard events
    static processDistinctUntilChanged1() {

        const keys$ = fromEvent(document, 'keyup')
            .pipe(
                distinctUntilKeyChanged<KeyboardEvent>('code'),
                pluck('key')
            );

        keys$.subscribe(console.log);


    }

    //An example comparing the first letters of the name
    static processDistinctUntilChanged2() {
        of<Person>(
            { age: 4, name: 'Foo1' },
            { age: 7, name: 'Bar' },
            { age: 5, name: 'Foo2' },
            { age: 6, name: 'Foo3' },
        ).pipe(
            distinctUntilKeyChanged('name', (x: string, y: string) => x.substring(0, 3) === y.substring(0, 3)),
        )
            .subscribe(x => console.log(x));

        // displays:
        // { age: 4, name: 'Foo1' }
        // { age: 7, name: 'Bar' }
        // { age: 5, name: 'Foo2' }
    }
}

interface Person {
    age: number,
    name: string
}