import { interval, Subject, ConnectableObservable, ReplaySubject } from 'rxjs';
import { take, tap, mapTo, multicast } from 'rxjs/operators';

export class Multicast {

    // multicast(selector: Function): Observable

    /* An Observable that emits the results of invoking the selector on the items emitted by a 
    ConnectableObservable that shares a single subscription to the underlying stream.*/

    static processMulticast() {
        //emit every 2 seconds, take 5
        const source = interval(2000).pipe(take(5));

        const example = source.pipe(
            //since we are multicasting below, side effects will be executed once
            tap(() => console.log('Side Effect #1')),
            mapTo('Result!')
        );

        //subscribe subject to source upon connect()
        const multi = example.pipe(multicast(() => new Subject())) as ConnectableObservable<String>;
        /*
          subscribers will share source
          output:
          "Side Effect #1"
          "Result!"
          "Result!"
          ...
        */
        const subscriberOne = multi.subscribe(val => console.log(val));
        const subscriberTwo = multi.subscribe(val => console.log(val));
        //subscribe subject to source
        multi.connect();
    }

    //multicast with ReplaySubject
    static processMulticast1() {
        //emit every 2 seconds, take 5
        const source = interval(2000).pipe(take(5));

        //example with ReplaySubject
        const example = source.pipe(
            //since we are multicasting below, side effects will be executed once
            tap(_ => console.log('Side Effect #2')),
            mapTo('Result Two!')
        );
        //can use any type of subject
        const multi = example.pipe(multicast(() => new ReplaySubject(5)))as ConnectableObservable<String>;
        //subscribe subject to source
        multi.connect();

        setTimeout(() => {
            /*
             subscriber will receieve all previous values on subscription because
             of ReplaySubject
             */
            const subscriber = multi.subscribe(val => console.log(val));
        }, 5000);
    }
}