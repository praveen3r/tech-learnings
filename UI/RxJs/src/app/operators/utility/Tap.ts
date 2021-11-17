import { map, tap } from 'rxjs/operators';
import { of } from 'rxjs';

export class Tap {

    //tap(nextOrObserver: function, error: function, complete: function): Observable

    /* An Observable identical to the source, but runs the specified Observer or callback(s) for each item.
    
    Intercepts each emission on the source and runs a function, but returns an output which is identical 
    to the source as long as errors don't occur.

    Returns a mirrored Observable of the source Observable, but modified so that the provided Observer 
    is called to perform a side effect for every value, error, and completion emitted by the source. 
    Any errors that are thrown in the aforementioned Observer or handlers are safely sent down the 
    error path of the output Observable.

    This operator is useful for debugging your Observables for the correct values or performing 
    other side effects.

    Note: this is different to a subscribe on the Observable. If the Observable returned by tap is 
    not subscribed, the side effects specified by the Observer will never happen. tap therefore 
    simply spies on existing execution, it does not trigger an execution to happen like subscribe does.

    */
    static processTap() {
        const source = of(1, 2, 3, 4, 5);
        // transparently log values from source with 'tap'
        const example = source.pipe(
            tap(val => console.log(`BEFORE MAP: ${val}`)),
            map(val => val + 10),
            tap(val => console.log(`AFTER MAP: ${val}`))
        );

        //'tap' does not transform values
        //output: 11...12...13...14...15
        const subscribe = example.subscribe(val => console.log(val));
    }
}