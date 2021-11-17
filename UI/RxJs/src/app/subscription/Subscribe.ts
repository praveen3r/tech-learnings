import { Observable, noop } from 'rxjs';

export class Subscribe {


    static processSubscribe() {

        const observable = new Observable(subscriber => {
            subscriber.next(1);
            subscriber.next(2);
            subscriber.next(3);
            setTimeout(() => {
                subscriber.next(4);
                subscriber.complete();
            }, 1000);
        });

        /* subscribe(onNext, onError, onCompleted)
      
        onNext
            An Observable calls this method whenever the Observable emits an item. 
            This method takes as a parameter the item emitted by the Observable.

        onError
            An Observable calls this method to indicate that it has failed to generate the expected
            data or has encountered some other error. This stops the Observable and it will not make 
            further calls to onNext or onCompleted. The onError method takes as its parameter an 
            indication of what caused the error (sometimes an object like an Exception or Throwable,
                 other times a simple string, depending on the implementation).

        onCompleted
            An Observable calls this method after it has called onNext for the final time, 
            if it has not encountered any errors. */

        console.log('just before subscribe');
        observable.subscribe({
            next(x) { console.log('got value ' + x); },
            error(err) { console.error('something wrong occurred: ' + err); },
            complete() { console.log('completed'); }
        });
        console.log('just after subscribe');


        //Example 2
        observable.subscribe(
            val =>  console.log(val),
            () => {},
            () => console.log('completed')
        );

        //Example 3
        observable.subscribe(
            val =>  console.log(val),
            noop, //equivalent to () => {}
            () => console.log('completed')
        );
    }
}
