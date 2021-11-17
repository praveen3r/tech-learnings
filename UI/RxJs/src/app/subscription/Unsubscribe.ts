import { interval } from 'rxjs';

export class Unsubscribe {


    static processUnsubscribe() {

        const source = interval(1000);

        const subscription = source.subscribe(val => console.log(val));

        // Later:
        // This cancels the ongoing Observable execution which
        // was started by calling subscribe with an Observer.
        //subscription.unsubscribe();

        setTimeout(() => subscription.unsubscribe(), 5000);
    }
}
