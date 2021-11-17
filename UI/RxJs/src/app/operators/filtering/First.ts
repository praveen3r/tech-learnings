import { from } from 'rxjs';
import { first } from 'rxjs/operators';

export class First {

    // first(predicate: function, select: function) 

    /* An Observable of the first item that matches the condition.

    Emits only the first value. Or emits only the first value that passes some test.

    If called with no arguments, first emits the first value of the source Observable, then completes. 
    If called with a predicate function, first emits the first value of the source that matches the 
    specified condition. It may also take a deprecated resultSelector function to produce the output
     value from the input value, and a defaultValue to emit in case the source completes before it is
      able to emit a valid value. Throws an error if defaultValue was not provided and a matching 
      element is not found.
    */
    static processFirst() {

        const source = from([1, 2, 3, 4, 5]);
        //no arguments, emit first value
        const example = source.pipe(first());
        //output: "First value: 1"
        const subscribe = example.subscribe(val => console.log(`First value: ${val}`));

    }

    //First value to pass predicate
    static processFirst1() {

        const source = from([1, 2, 3, 4, 5]);

        //emit first item to pass test
        const example = source.pipe(first(num => num === 5));

        //output: "First to pass test: 5"
        const subscribe = example.subscribe(val =>
            console.log(`First to pass test: ${val}`)
        );


    }

    // Utilizing default value
    static processFirst2() {

        const source = from([1, 2, 3, 4, 5]);

        //no value will pass, emit default
        const example = source.pipe(first(val => val > 5, 'Nothing'));
        
        //output: 'Nothing'
        const subscribe = example.subscribe(val => console.log(val));

    }
}