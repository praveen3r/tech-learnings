import { from, range, interval } from 'rxjs';
import { first, single, skip, filter } from 'rxjs/operators';

export class Skip {

    // skip(the: Number): Observable

    /* An Observable that skips values emitted by the source Observable.
    */

    //Skipping values before emission
    static processSkip() {

        //emit every 1s
        const source = interval(1000);
        //skip the first 5 emitted values
        const example = source.pipe(skip(5));
        //output: 5...6...7...8........
        const subscribe = example.subscribe(val => console.log(val));

    }

    //Short hand for a specific filter use case
    static processSkip1() {

        const numArrayObs = from([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);

        // 3,4,5...
        const skipObs = numArrayObs.pipe(skip(2)).subscribe(console.log);

        // 3,4,5...
        const filterObs = numArrayObs
            .pipe(filter((val, index) => index > 1))
            .subscribe(console.log);


    }

}