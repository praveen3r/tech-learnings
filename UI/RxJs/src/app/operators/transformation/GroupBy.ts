import { of, merge, interval, from, zip } from 'rxjs';
import { take, delay, exhaustMap, expand, groupBy, mergeMap, toArray } from 'rxjs/operators';

export class GroupBy {

    //groupBy(keySelector: Function, elementSelector: Function): Observable

    /* An Observable that emits GroupedObservables, each of which corresponds to a unique key value 
        and each of which emits those items from the source Observable that share that key value.
    
       When the Observable emits an item, a key is computed for this item with the keySelector function.

        If a GroupedObservable for this key exists, this GroupedObservable emits. 
        Elsewhere, a new GroupedObservable for this key is created and emits.

        A GroupedObservable represents values belonging to the same group represented by a common key. 
        The common key is available as the key field of a GroupedObservable instance.

        The elements emitted by GroupedObservables are by default the items emitted by the Observable, 
        or elements returned by the elementSelector function.
        */

    //Group by property
    static processGroupBy() {

        const people = [
            { name: 'Sue', age: 25 },
            { name: 'Joe', age: 30 },
            { name: 'Frank', age: 25 },
            { name: 'Sarah', age: 35 }
          ];
          //emit each person
          const source = from(people);
          //group by age
          const example = source.pipe(
            groupBy(person => person.age),
            // return each item in group as array
            mergeMap(group => group.pipe(toArray()))
          );
          /*
            output:
            [{age: 25, name: "Sue"},{age: 25, name: "Frank"}]
            [{age: 30, name: "Joe"}]
            [{age: 35, name: "Sarah"}]
          */
          const subscribe = example.subscribe(val => console.log(val));
    }

    //Group by into key - values
    static processGroupBy1() {
        const people = [
            { name: 'Sue', age: 25 },
            { name: 'Joe', age: 30 },
            { name: 'Frank', age: 25 },
            { name: 'Sarah', age: 35 }
          ];
          
          from(people)
            .pipe(
              groupBy(person => person.age, p => p.name),
              mergeMap(group => zip(of(group.key), group.pipe(toArray())))
            )
            .subscribe(console.log);
          
          /*
            output:
            [25, ["Sue", "Frank"]]
            [30, ["Joe"]]
            [35, ["Sarah"]]
          */
    }
}