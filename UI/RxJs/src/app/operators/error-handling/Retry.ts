import { of, throwError, interval } from 'rxjs';
import { retry, mergeMap } from 'rxjs/operators';

export class Retry {

    // retry(number: number): Observable

    /*
    The source Observable modified with the retry logic.
    
    Any and all items emitted by the source Observable will be emitted by the resulting Observable, 
    even those emitted during failed subscriptions. For example, if an Observable fails at first but 
    emits [1, 2] then succeeds the second time and emits: [1, 2, 3, 4, 5] then the complete stream of 
    emissions and notifications would be: [1, 2, 1, 2, 3, 4, 5, complete].
    */

    
    static processRetry() {
        const source = interval(1000);
        const example = source.pipe(
            mergeMap(val => {
                //throw error for demonstration
                if (val > 5) {
                    return throwError('Error!');
                }
                return of(val);
            }),
            //retry 2 times on error
            retry(2)
        );
        /*
          output:
          0..1..2..3..4..5..
          0..1..2..3..4..5..
          0..1..2..3..4..5..
          "Error!: Retried 2 times then quit!"
        */
        const subscribe = example.subscribe({
            next: val => console.log(val),
            error: val => console.log(`${val}: Retried 2 times then quit!`)
        });
    }
}