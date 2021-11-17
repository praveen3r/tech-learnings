import { AsyncSubject } from 'rxjs';

export class TestAsyncSubject {

    // Emits its last value on completion

    static processAsyncSubject() {

        const sub = new AsyncSubject();

        sub.subscribe(console.log);

        sub.next(123); //nothing logged

        sub.subscribe(console.log);

        sub.next(456); //nothing logged
        sub.complete(); //456, 456 logged by both subscribers

    }
}