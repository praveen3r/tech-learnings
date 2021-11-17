import { interval } from 'rxjs';
import { take, toArray } from 'rxjs/operators';



export class ToArray {

    //toArray(): OperatorFunction

    /*
    An array from an observable sequence.

    Get all values inside an array when the source completes

    toArray will wait until the source Observable completes before emitting the array 
    containing all emissions. When the source Observable errors no array will be emitted.

    */

    static processToArray() {
        interval(100)
            .pipe(
                take(10),
                toArray()
            )
            .subscribe(console.log);

        // output: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }


}

