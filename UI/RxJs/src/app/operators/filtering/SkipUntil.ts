import { from, range, interval, timer } from 'rxjs';
import { first, single, skip, filter, skipUntil } from 'rxjs/operators';

export class SkipUntil {

    // skipUntil(the: Observable): Observable

    /* An Observable that skips items from the source Observable until the second Observable emits an 
        item, then emits the remaining items.

        The skipUntil operator causes the observable stream to skip the emission of values ​​until the 
        passed in observable emits the first value. This can be particularly useful in combination 
        with user interactions, responses of http requests or waiting for specific times to pass by.

        Internally the skipUntil operator subscribes to the passed in observable (in the following 
        called notifier) in order to recognize the emission of its first value. When this happens,
         the operator unsubscribes from the notifier and starts emitting the values of the source 
         observable. It will never let the source observable emit any values if the notifier 
         completes or throws an error without emitting a value before.
    */

    //Skipping values before emission
    static processSkipUntil() {

        //emit every 1s
        const source = interval(1000);
        //skip emitted values from source until inner observable emits (6s)
        const example = source.pipe(skipUntil(timer(6000)));
        //output: 5...6...7...8........
        const subscribe = example.subscribe(val => console.log(val));

    }

}