import { share, tap, mapTo } from 'rxjs/operators';
import { timer } from 'rxjs';

export class Share {

    // share(): Observable

    /* An Observable that upon connection causes the source Observable to emit items to its Observers.
    
    Returns a new Observable that multicasts (shares) the original Observable. As long as there is at 
    least one Subscriber this Observable will be subscribed and emitting data. When all subscribers 
    have unsubscribed it will unsubscribe from the source Observable. Because the Observable is 
    multicasting it makes the stream hot. This is an alias for multicast(() => new Subject()), refCount().*/

    static processShare() {

        //emit value in 1s
        const source = timer(1000);
        //log side effect, emit result
        const example = source.pipe(
            tap(() => console.log('***SIDE EFFECT***')),
            mapTo('***RESULT***')
        );

        /*
          ***NOT SHARED, SIDE EFFECT WILL BE EXECUTED TWICE***
          output:
          "***SIDE EFFECT***"
          "***RESULT***"
          "***SIDE EFFECT***"
          "***RESULT***"
        */
        const subscribe = example.subscribe(val => console.log(val));
        const subscribeTwo = example.subscribe(val => console.log(val));

        //share observable among subscribers
        const sharedExample = example.pipe(share());
        /*
          ***SHARED, SIDE EFFECT EXECUTED ONCE***
          output:
          "***SIDE EFFECT***"
          "***RESULT***"
          "***RESULT***"
        */
        const subscribeThree = sharedExample.subscribe(val => console.log(val));
        const subscribeFour = sharedExample.subscribe(val => console.log(val));
    }
}