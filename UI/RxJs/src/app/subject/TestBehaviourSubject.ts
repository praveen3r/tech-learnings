import { BehaviorSubject } from 'rxjs';
import { take } from 'rxjs/operators';

export class TestBehaviourSubject {

    /* 
        A variant of Subject that requires an initial value and emits its current value whenever
        it is subscribed to.
    */
    static processBehaviourSubject() {

        const subject = new BehaviorSubject(123);

        // two new subscribers will get initial value => output: 123, 123
        subject.subscribe(console.log);
        subject.subscribe(console.log);

        // two subscribers will get new value => output: 456, 456
        subject.next(456);

        // new subscriber will get latest value (456) => output: 456
        subject.subscribe(console.log);

        // all three subscribers will get new value => output: 789, 789, 789
        subject.next(789);

        // output: 123, 123, 456, 456, 456, 789, 789, 789

    }

    static processBehaviourSubject1() {
        const subject = new BehaviorSubject(123);

        subject.next(456);

        // two new subscribers will get initial value => output: 123, 123
        subject.pipe(take(1)).subscribe(console.log);
        subject.pipe(take(1)).subscribe(console.log);

        subject.next(457);
        //subject.unsubscribe();

    }
}