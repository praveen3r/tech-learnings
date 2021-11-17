import { Subject, noop } from 'rxjs';

export class TestSubject {

    /*
    What is a Subject? An RxJS Subject is a special type of Observable that allows values to be
     multicasted to many Observers. While plain Observables are unicast (each subscribed Observer 
    owns an independent execution of the Observable), Subjects are multicast.


    A Subject is like an Observable, but can multicast to many Observers. Subjects are like 
    EventEmitters: they maintain a registry of many listeners.

    Every Subject is an Observable. Given a Subject, you can subscribe to it, providing an 
    Observer, which will start receiving values normally. From the perspective of the Observer, 
    it cannot tell whether the Observable execution is coming from a plain unicast Observable or 
    a Subject.

    Internally to the Subject, subscribe does not invoke a new execution that delivers values.
    It simply registers the given Observer in a list of Observers, similarly to how addListener 
    usually works in other libraries and languages.

    Every Subject is an Observer. It is an object with the methods next(v), error(e), and complete().
    To feed a new value to the Subject, just call next(theValue), and it will be multicasted to the 
    Observers registered to listen to the Subject.

    In the example below, we have two Observers attached to a Subject, and we feed some values to the 
    Subject:

    */
    static processSubject() {

        const subject = new Subject<number>();
 
        subject.subscribe({
            next: (v) => console.log(`observerA: ${v}`)
        });
        
        subject.subscribe(val => console.log(`observerB: ${val}`), noop, noop);
        
        subject.next(1);
        subject.next(2);
        subject.complete();

        subject.unsubscribe();
    }
}