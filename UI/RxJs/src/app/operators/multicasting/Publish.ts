import { interval, Observable, ConnectableObservable } from 'rxjs';
import { tap, publish } from 'rxjs/operators';

export class Publish {

    // publish() : ConnectableObservable

    /*
    A ConnectableObservable that upon connection causes the source Observable to emit items to its 
    Observers.

    Makes a cold Observable hot
    */


    static processPublish() {
        //emit value every 1 second
        const source = interval(1000);
        const example = source.pipe(
            //side effects will be executed once
            tap(_ => console.log('Do Something!')),
            //do nothing until connect() is called
            publish()
        ) as ConnectableObservable<String>;

        /*
          source will not emit values until connect() is called
          output: (after 5s)
          "Do Something!"
          "Subscriber One: 0"
          "Subscriber Two: 0"
          "Do Something!"
          "Subscriber One: 1"
          "Subscriber Two: 1"
        */
        const subscribe = example.subscribe(val =>
            console.log(`Subscriber One: ${val}`)
        );
        const subscribeTwo = example.subscribe(val =>
            console.log(`Subscriber Two: ${val}`)
        );

        //call connect after 5 seconds, causing source to begin emitting items
        setTimeout(() => {
            example.connect();
        }, 5000);
    }
}