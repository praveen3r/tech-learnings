import { of } from 'rxjs';
import { endWith, finalize } from 'rxjs/operators';

export class EndWith {
    // endWith(an: Values): Observable

    /* An Observable that emits the items emitted by the source Observable and then emits the items 
    in the specified Iterable.*/

    static processEndWith() {
        const source$ = of('Hello', 'Friend', 'Goodbye');

        source$
            // emit on completion
            .pipe(endWith('Friend'))
            // 'Hello', 'Friend', 'Goodbye', 'Friend'
            .subscribe(console.log);
    }

    //endWith multiple values
    static processEndWith1() {
        const source$ = of('Hello', 'Friend');

        source$.pipe(endWith('Goodbye', 'Friend'))
            // 'Hello', 'Friend', 'Goodbye', 'Friend'
            .subscribe(console.log);
    }

    //Comparison to finalize
    static processEndWith2() {
        const source$ = of('Hello', 'Friend');

        source$.pipe(
                endWith('Goodbye', 'Friend'),
                // this function is invoked when unsubscribe methods are called
                finalize(() => console.log('Finally'))
            )
            // 'Hello', 'Friend', 'Goodbye', 'Friend'
            .subscribe(val => console.log(val));
        // 'Finally'
    }
}
