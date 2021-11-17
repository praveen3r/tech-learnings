import { fromEvent, interval } from 'rxjs';
import { audit } from 'rxjs/operators';

export class Audit {

    //audit(durationSelector: (value) => Observable | Promise): Observable

    /* An Observable that performs rate-limiting of emissions from the source Observable.

        It's like auditTime, but the silencing duration is determined by a second Observable.

        audit is similar to throttle, but emits the last value from the silenced time window, 
        instead of the first value. audit emits the most recent value from the source Observable
         on the output Observable as soon as its internal timer becomes disabled, and ignores 
         source values while the timer is enabled. Initially, the timer is disabled. As soon as 
         the first source value arrives, the timer is enabled by calling the durationSelector 
         function with the source value, which returns the "duration" Observable. When the duration 
         Observable emits a value or completes, the timer is disabled, then the most recent source 
         value is emitted on the output Observable, and this process repeats for the next source value.

    */


    //Emit clicks at a rate of at most one click per second
    static processAudit() {
        const clicks = fromEvent(document, 'click');
        const result = clicks.pipe(audit(ev => interval(1000)));
        result.subscribe(x => console.log(x));
    }
}