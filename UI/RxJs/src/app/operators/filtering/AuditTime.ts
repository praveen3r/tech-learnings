import { fromEvent } from 'rxjs';
import { auditTime } from 'rxjs/operators';


export class AuditTime {

    //auditTime(duration: number, scheduler?: Scheduler): Observable

    /* An Observable that performs rate-limiting of emissions from the source Observable.

        When it sees a source value, it ignores that plus the next ones for duration milliseconds, 
        and then it emits the most recent value from the source.

        auditTime is similar to throttleTime, but emits the last value from the silenced time window, 
        instead of the first value. auditTime emits the most recent value from the source Observable 
        on the output Observable as soon as its internal timer becomes disabled, and ignores source 
        values while the timer is enabled. Initially, the timer is disabled. As soon as the first 
        source value arrives, the timer is enabled. After duration milliseconds 
        (or the time unit determined internally by the optional scheduler) has passed, the 
        timer is disabled, then the most recent source value is emitted on the output Observable, 
        and this process repeats for the next source value. Optionally takes a SchedulerLike for 
        managing timers.

    */


    //Emit clicks at a rate of at most one click per second
    static processAuditTime() {
        // Create observable that emits click events
        const source = fromEvent(document, 'click');
        // Emit clicks at a rate of at most one click per second
        const example = source.pipe(auditTime(1000))
        // Output (example): '(1s) --- Clicked --- (1s) --- Clicked' 
        const subscribe = example.subscribe(val => console.log('Clicked'));
    }
}