import { merge, from, Observable, of } from 'rxjs';
import { map, partition, pluck, reduce } from 'rxjs/operators';


export class Reduce {

    //reduce(accumulator: function, seed: any): Observable

    /* An Observable that emits a single value that is the result of accumulating 
    the values emitted by the source Observable.
    
    Combines together all values emitted on the source, using an accumulator function that 
    knows how to join a new source value into the accumulation from the past.
    
    Like Array.prototype.reduce(), reduce applies an accumulator function against an accumulation 
    and each value of the source Observable (from the past) to reduce it to a single value, 
    emitted on the output Observable. Note that reduce will only emit one value, only when the 
    source Observable completes. It is equivalent to applying operator scan followed by operator last.

    Returns an Observable that applies a specified accumulator function to each item emitted by 
    the source Observable. If a seed value is specified, then that value will be used as the initial 
    value for the accumulator. If no seed value is specified, the first item of the source is used as
    the seed.

    */


    static processReduce() {
        const source = of(1, 2, 3, 4);
        const example = source.pipe(reduce((acc, val) => acc + val));
        //output: Sum: 10'
        const subscribe = example.subscribe(val => console.log('Sum:', val));
    }
 

}

