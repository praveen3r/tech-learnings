import { interval, asyncScheduler } from 'rxjs';
import { throttleTime } from 'rxjs/operators';


export class ThrottleTime {

    //throttleTime(duration: number, scheduler: Scheduler, config: ThrottleConfig): Observable 

    /* 
    An Observable that performs the throttle operation to limit the rate of emissions from the source.

    Lets a value pass, then ignores source values for the next duration milliseconds

    throttleTime emits the source Observable values on the output Observable when its internal 
    timer is disabled, and ignores source values when the timer is enabled. Initially, 
    the timer is disabled. As soon as the first source value arrives, it is forwarded to the
     output Observable, and then the timer is enabled. After duration milliseconds
      (or the time unit determined internally by the optional scheduler) has passed, 
      the timer is disabled, and this process repeats for the next source value. Optionally 
      takes a SchedulerLike for managing timers.
    */

    static processThrottleTime() {
        // emit value every 1 second
        const source = interval(1000);

        /*
          emit the first value, then ignore for 5 seconds. repeat...
        */
        const example = source.pipe(throttleTime(5000));

        // output: 0...6...12
        const subscribe = example.subscribe(val => console.log(val));

    }

    static processThrottleTimeWithConfig() {

        const source = interval(1000);

        /*
          emit the first value, then ignore for 5 seconds. repeat...
        */
        const example = source.pipe(throttleTime(
            5000,
            asyncScheduler,
            { trailing: true }
        ));
        
        // output: 5...11...17
        const subscribe = example.subscribe(val => console.log(val));

    }
}