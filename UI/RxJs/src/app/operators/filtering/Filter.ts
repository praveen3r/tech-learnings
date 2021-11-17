import { from } from 'rxjs';
import { filter } from 'rxjs/operators';


export class Filter {


    //filter(select: Function, thisArg: any): Observable 

    /* Similar to the well-known Array.prototype.filter method, this operator takes values from the 
    source Observable, passes them through a predicate function and only emits those values that 
    yielded true */

    static processFilter() {

        const source = from([1, 2, 3, 4, 5]);
        const example = source.pipe(filter(num => num % 2 === 0));
        const subscribe = example.subscribe(val => console.log(`Even number: ${val}`));

    }

    //filter objects based on property
    static processFilter1() {
        //emit ({name: 'Joe', age: 31}, {name: 'Bob', age:25})
        const source = from([
            { name: 'Joe', age: 31 },
            { name: 'Bob', age: 25 }
        ]);
        //filter out people with age under 30
        const example = source.pipe(filter(person => person.age >= 30));
        //output: "Over 30: Joe"
        const subscribe = example.subscribe(val => console.log(`Over 30: ${val.name}`));
    }

}