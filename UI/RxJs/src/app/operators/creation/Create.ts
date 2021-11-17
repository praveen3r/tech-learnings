import { Observable } from 'rxjs';

export class Create {


    static processCreate() {
        /*create(subscribe: function)

        Create an observable with given subscription function*/

        /*
        There are three types of values an Observable Execution can deliver:

            "Next" notification: sends a value such as a Number, a String, an Object, etc.
            "Error" notification: sends a JavaScript Error or exception.
            "Complete" notification: does not send a value.
        */
        const observable = Observable.create(function (observer) {
            observer.next('Hello');
            observer.next('World');
            observer.complete();
        });

        //output: 'Hello'...'World'
        observable.subscribe(
            val => console.log(`value is ${val}`),
            error => console.log(`value is ${error}`),
            () => console.log('completed')
        );

        /* "Next" notifications are the most important and most common type: they represent actual data 
        being delivered to an subscriber. "Error" and "Complete" notifications may happen only once 
        during the Observable Execution, and there can only be either one of them.
        
        In an Observable Execution, zero to infinite Next notifications may be delivered. If either 
        an Error or Complete notification is delivered, then nothing else can be delivered afterwards.*/

        const observable1 = new Observable(function subscribe(subscriber) {
            subscriber.next(1);
            subscriber.next(2);
            subscriber.next(3);
            subscriber.complete();
            subscriber.next(4); // Is not delivered because it would violate the contract
          });

          /* It is a good idea to wrap any code in subscribe with try/catch block that will deliver
           an Error notification if it catches an exception:*/
           
          const observable2 = new Observable(function subscribe(subscriber) {
            try {
              subscriber.next(1);
              subscriber.next(2);
              subscriber.next(3);
              subscriber.complete();
            } catch (err) {
              subscriber.error(err); // delivers an error if it caught one
            }
          });
    }
}