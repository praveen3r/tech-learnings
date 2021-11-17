import { fromEvent } from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';

export class DebounceTime {

    //debounceTime(dueTime: number, scheduler: Scheduler): Observable 

    /* An Observable that delays the emissions of the source Observable by the specified dueTime, 
    and may drop some values if they occur too frequently.
    
    It's like delay, but passes only the most recent value from each burst of emissions.
    
    Observable, and emits that only when dueTime enough time has passed without any other value 
    appearing on the source Observable. If a new value appears before dueTime silence occurs, 
    the previous value will be dropped and will not be emitted on the output Observable.

    This is a rate-limiting operator, because it is impossible for more than one value to be emitted 
    in any time window of duration dueTime, but it is also a delay-like operator since output 
    emissions do not occur at the same time as they did on the source Observable. Optionally takes 
    a SchedulerLike for managing timers. */

    static processDebounceTime() {

        // elem ref
        const searchBox = document.getElementById('search');

        // streams
        const keyup$ = fromEvent(searchBox, 'keyup');

        // wait .5s between keyups to emit current value
        keyup$
            .pipe(
                map((i: any) => i.currentTarget.value),
                debounceTime(500)
            )
            .subscribe(console.log);
    }

    static processDebounceTime1() {

        const clicks = fromEvent(document, 'click');
        const result = clicks.pipe(debounceTime(3000));
        result.subscribe(x => console.log(x));
    }
}