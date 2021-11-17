import { from, asyncScheduler } from 'rxjs';
import { take } from 'rxjs/operators';

export class From {

    /* Creates an Observable from an Array, an array-like object, a Promise, an iterable object, 
    or an Observable-like object.*/

    static processFrom() {

        const array = [10, 20, 30];
        const result = from(array);

        result.subscribe(x => console.log(x));
    }

    //Convert an infinite iterable (from a generator) to an Observable
    static processFrom1() {
        const iterator = generateDoubles(3);
        const result = from(iterator).pipe(take(10));
        
        result.subscribe(x => console.log(x));
    }

    static processFrom2() {
        const array = [10, 20, 30];
        const result = from(array, asyncScheduler);
        
        result.subscribe(x => console.log(x));
    }
    
}

function* generateDoubles(seed) {
    let i = seed;
    while (true) {
      yield i;
      i = 2 * i; // double it
    }
 }