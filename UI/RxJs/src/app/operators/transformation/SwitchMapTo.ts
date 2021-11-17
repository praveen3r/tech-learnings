import { fromEvent, interval } from 'rxjs';
import { scan, startWith, switchMapTo, takeWhile, finalize } from 'rxjs/operators';



export class SwitchMapTo {

    //switchMapTo(innerObservable: Observable, resultSelector: function(outerValue, innerValue, outerIndex, innerIndex): any): Observable
   
    /*
    An Observable that emits items from the given innerObservable (and optionally transformed through 
    the deprecated resultSelector) every time a value is emitted on the source Observable, and 
    taking only the values from the most recently projected inner Observable.

    It's like switchMap, but maps each value always to the same inner Observable.

    Maps each source value to the given Observable innerObservable regardless of the source value, 
    and then flattens those resulting Observables into one single Observable, which is the output 
    Observable. The output Observables emits values only from the most recently emitted instance of 
    innerObservable.

    */

    //Restart countdown on click, until countdown completes one time
    static processSwitchMapTo() {
        const COUNTDOWN_TIME = 10;

        // reference
        const countdownElem = document.getElementById('countdown');

        // streams
        const click$ = fromEvent(document, 'click');
        const countdown$ = interval(1000).pipe(
            scan((acc, _) => --acc, COUNTDOWN_TIME),
            startWith(COUNTDOWN_TIME)
        );

        click$
            .pipe(
                switchMapTo(countdown$),
                takeWhile(val => val >= 0),
                finalize(() => (countdownElem.innerHTML = "We're done here!"))
            )
            .subscribe((val: any) => (countdownElem.innerHTML = val));
    }


}

