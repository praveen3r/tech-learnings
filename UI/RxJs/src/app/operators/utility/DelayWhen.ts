import { interval, timer } from 'rxjs';
import { delayWhen } from 'rxjs/operators';

export class DelayWhen {

    //delayWhen(selector: Function, sequence: Observable): Observable

    /* An Observable that delays the emissions of the source Observable by an amount of time specified 
    by the Observable returned by delayDurationSelector.

    It's like delay, but the time span of the delay duration is determined by a second Observable

    delayWhen time shifts each emitted value from the source Observable by a time span determined by 
    another Observable. When the source emits a value, the delayDurationSelector function is called 
    with the source value as argument, and should return an Observable, called the "duration" Observable. The source value is emitted on the output Observable only when the duration Observable emits a value or completes. The completion of the notifier triggering the emission of the source value is deprecated behavior and will be removed in future versions.

    Optionally, delayWhen takes a second argument, subscriptionDelay, which is an Observable. When 
    subscriptionDelay emits its first value or completes, the source Observable is subscribed to and 
    starts behaving like described in the previous paragraph. If subscriptionDelay is not provided, 
    delayWhen will subscribe to the source Observable as soon as the output Observable is subscribed.

    */

    //Delay to recognize long press
    static processDelayWhen() {
        //emit value every second
        const message = interval(1000);
        //emit value after five seconds
        const delayForFiveSeconds = () => timer(5000);
        //after 5 seconds, start emitting delayed interval values
        const delayWhenExample = message.pipe(delayWhen(delayForFiveSeconds));
        //log values, delayed for 5 seconds
        //ex. output: 5s....1...2...3
        const subscribe = delayWhenExample.subscribe(val => console.log(val));
    }
}