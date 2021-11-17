import { of, defer, merge, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';

export class Defer {

    //defer(observableFactory: function(): SubscribableOrPromise): Observable

    /* An Observable whose Observers' subscriptions trigger an invocation of the 
        given Observable factory function. 
        
    Creates the Observable lazily, that is, only when it is subscribed.
    
    defer allows you to create the Observable only when the Observer subscribes, 
    and create a fresh Observable for each Observer. It waits until an Observer subscribes to it, 
    and then it generates an Observable, typically with an Observable factory function.
     It does this afresh for each subscriber, so although each subscriber may think it is 
     subscribing to the same Observable, in fact each subscriber gets its own individual Observable.*/

    //Emitting a sequence of numbers
    static processDefer() {
        
        const s1 = of(new Date()); //will capture current date time
        const s2 = defer(() => of(new Date())); //will capture date time at the moment of subscription

        timer(2000)
            .pipe(switchMap(_ => merge(s1, s2)))
            .subscribe(console.log);
    }
}