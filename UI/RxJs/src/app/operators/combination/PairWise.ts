import { interval } from 'rxjs';
import { pairwise, take } from 'rxjs/operators';

export class PairWise {

    //pairwise(): Observable<Array>

    /* An Observable of pairs (as arrays) of consecutive values from the source Observable.
    
    Puts the current value and previous value together as an array, and emits that.*/
    static processPairWise() {

        //Returns: [0,1], [1,2], [2,3], [3,4], [4,5]
        interval(1000)
            .pipe(
                pairwise(),
                take(5)
            )
            .subscribe(console.log);
    }

}