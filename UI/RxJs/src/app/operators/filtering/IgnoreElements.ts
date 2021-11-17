import { fromEvent, interval, throwError, of } from 'rxjs';
import { find, take, ignoreElements, mergeMap } from 'rxjs/operators';

export class IgnoreElements {


    //ignoreElements(): Observable

    /* An empty Observable that only calls complete or error, based on which one is called by the source
     Observable.
    */

    //Ignore all elements from source
    static processIgnoreElements() {
        //emit value every 100ms
        const source = interval(100);
        //ignore everything but complete
        const example = source.pipe(
            take(5),
            ignoreElements()
        );
        //output: "COMPLETE!"
        const subscribe = example.subscribe(
            val => console.log(`NEXT: ${val}`),
            val => console.log(`ERROR: ${val}`),
            () => console.log('COMPLETE!')
        );
    }

    //Only displaying error
    static processIgnoreElements1() {
        //emit value every 100ms
        const source = interval(100);
        //ignore everything but error
        const error = source.pipe(
            mergeMap(val => {
                if (val === 4) {
                    return throwError(`ERROR AT ${val}`);
                }
                return of(val);
            }),
            ignoreElements()
        );
        //output: "ERROR: ERROR AT 4"
        const subscribe = error.subscribe(
            val => console.log(`NEXT: ${val}`),
            val => console.log(`ERROR: ${val}`),
            () => console.log('SECOND COMPLETE!')
        );
    }
}