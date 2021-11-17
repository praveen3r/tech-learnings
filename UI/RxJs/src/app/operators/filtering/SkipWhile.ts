import { from, range, interval, timer } from 'rxjs';
import { first, single, skip, filter, skipUntil, skipWhile } from 'rxjs/operators';

export class SkipWhile {

    // skipWhile(predicate: Function): Observable

    /* An Observable that begins emitting items emitted by the source Observable when the 
        specified predicate becomes false.        
    */

    //Skipping values before emission
    static processSkipWhile() {

        //emit every 1s
        const source = interval(1000);
        //skip emitted values from source while value is less than 5
        const example = source.pipe(skipWhile(val => val < 5));
        //output: 5...6...7...8........
        const subscribe = example.subscribe(val => console.log(val));

    }

}