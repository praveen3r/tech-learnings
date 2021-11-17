import { merge, from, Observable } from 'rxjs';
import { map, partition } from 'rxjs/operators';


export class Partition {

    //partition(predicate: function: boolean, thisArg: any): [Observable, Observable]

    /* An array with two Observables: one with values that passed the predicate, 
    and another with values that did not pass the predicate. 
    
    It's like filter, but returns two Observables: one like the output of filter, 
    and the other with values that did not pass the condition. 
    
    partition outputs an array with two Observables that partition the values from the source 
    Observable through the given predicate function. The first Observable in that array emits 
    source values for which the predicate argument returns true. The second Observable emits 
    source values for which the predicate returns false. The first behaves like filter and the 
    second behaves like filter with the predicate negated.*/


    //Split even and odd numbers
    static processPartition() {
        const source = from([1, 2, 3, 4, 5, 6]);
        //first value is true, second false
        //const [evens, odds] = source.pipe(partition(val => val % 2 === 0));
        /*
          Output:
          "Even: 2"
          "Even: 4"
          "Even: 6"
          "Odd: 1"
          "Odd: 3"
          "Odd: 5"
        
        const subscribe = merge(
            evens.pipe(map(val => `Even: ${val}`)),
            odds.pipe(map(val => `Odd: ${val}`))
        ).subscribe(val => console.log(val));*/
    }

}

