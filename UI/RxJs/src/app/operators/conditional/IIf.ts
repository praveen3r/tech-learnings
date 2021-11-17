import { of, interval, iif } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

export class Iif {
    // iif(condition: () => boolean, trueResult: SubscribableOrPromise = EMPTY, falseResult: SubscribableOrPromise = EMPTY): Observable

    /*
    iif accepts a condition function and two Observables. When an Observable returned by the operator 
    is subscribed, condition function will be called. Based on what boolean it returns at that moment, 
    consumer will subscribe either to the first Observable (if condition was true) or to the second 
    (if condition was false). Condition function may also not return anything - in that case condition 
    will be evaluated as false and second Observable will be subscribed.

    Note that Observables for both cases (true and false) are optional. If condition points to an 
    Observable that was left undefined, resulting stream will simply complete immediately. That allows you 
    to, rather than controlling which Observable will be subscribed, decide at runtime if consumer should 
    have access to given Observable or not.

    If you have more complex logic that requires decision between more than two Observables, 
    defer will probably be a better choice. Actually iif can be easily implemented with defer and 
    exists only for convenience and readability reasons.
    */

    static processIif() {
        const r$ = of('R');
        const x$ = of('X');

        interval(1000)
            .pipe(mergeMap(v => iif(() => v % 4 === 0, r$, x$)))
            .subscribe(console.log);
    }

    //iif with default
    static processIif1() {
        interval(1000)
            .pipe(
                mergeMap(v =>
                    iif(
                        () => !!(v % 2),
                        of(v)
                        // if not supplied defaults to EMPTY
                    )
                )
                // output: 1,3,5...
            )
            .subscribe(console.log);
    }

    //Simple
    static processIif2() {
        let subscribeToFirst;
        const firstOrSecond = iif(
            () => subscribeToFirst,
            of('first'),
            of('second'),
        );

        subscribeToFirst = true;
        firstOrSecond.subscribe(value => console.log(value));

        // Logs:
        // "first"

        subscribeToFirst = false;
        firstOrSecond.subscribe(value => console.log(value));

        // Logs:
        // "second"
    }

    //Access control
    static processIif3() {
        let accessGranted;
        const observableIfYouHaveAccess = iif(
            () => accessGranted,
            of('It seems you have an access...'), // Note that only one Observable is passed to the operator.
        );

        accessGranted = true;
        observableIfYouHaveAccess.subscribe(
            value => console.log(value),
            err => { },
            () => console.log('The end'),
        );

        // Logs:
        // "It seems you have an access..."
        // "The end"

        accessGranted = false;
        observableIfYouHaveAccess.subscribe(
            value => console.log(value),
            err => { },
            () => console.log('The end'),
        );

        // Logs:
        // "The end"
    }
}