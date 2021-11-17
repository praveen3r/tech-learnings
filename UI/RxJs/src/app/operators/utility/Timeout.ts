import { of, interval } from 'rxjs';
import { delay, concatMap, timeout, catchError } from 'rxjs/operators';

export class TimeOut {

    //timeout(due: number, scheduler: Scheduler): Observable

    /* Observable that mirrors behaviour of source, unless timeout checks fail.

        Timeouts on Observable that doesn't emit values fast enough.

        timeout operator accepts as an argument either a number or a Date.

        If number was provided, it returns an Observable that behaves like a source Observable, 
        unless there is a period of time where there is no value emitted. So if you provide 100 
        as argument and first value comes after 50ms from the moment of subscription, this value 
        will be simply re-emitted by the resulting Observable. If however after that 100ms passes
         without a second value being emitted, stream will end with an error and source Observable 
         will be unsubscribed. These checks are performed throughout whole lifecycle of Observable 
         - from the moment it was subscribed to, until it completes or errors itself. Thus every 
         value must be emitted within specified period since previous value.

        If provided argument was Date, returned Observable behaves differently. 
        It throws if Observable did not complete before provided Date. This means that periods 
        between emission of particular values do not matter in this case. If Observable did not 
        complete before provided Date, source Observable will be unsubscribed. Other than that, 
        resulting stream behaves just as source Observable.

        timeout accepts also a Scheduler as a second parameter. It is used to schedule moment (or moments) when returned Observable will check if source stream emitted value or completed.


    */

    static processTimeOut() {
        const seconds = interval(1000);

        seconds.pipe(timeout(1100))      // Let's use bigger timespan to be safe,
            // since `interval` might fire a bit later then scheduled.
            .subscribe(
                value => console.log(value), // Will emit numbers just as regular `interval` would.
                err => console.log(err),     // Will never be called.
            );

        seconds.pipe(timeout(900))
            .subscribe(
                value => console.log(value), // Will never be called.
                err => console.log(err),     // Will emit error before even first value is emitted,
                // since it did not arrive within 900ms period.
            );

    }


    //Use Date to check if Observable completed
    static processTimeOut1() {
        const seconds = interval(1000);

        seconds.pipe(
            timeout(new Date("December 17, 2020 03:24:00")),
        )
            .subscribe(
                value => console.log(value), // Will emit values as regular `interval` would
                // until December 17, 2020 at 03:24:00.
                err => console.log(err)      // On December 17, 2020 at 03:24:00 it will emit an error,
                // since Observable did not complete by then.
            );

    }

    // simulate request
    static makeRequest(timeToDelay) {
        return of('Request Complete!').pipe(delay(timeToDelay));
    }

    static processTimeOut2() {
        of(4000, 3000, 2000)
            .pipe(
                concatMap(duration =>
                    TimeOut.makeRequest(duration).pipe(
                        timeout(2500),
                        catchError(error => of(`Request timed out after: ${duration}`))
                    )
                )
            )
            /*
             *  "Request timed out after: 4000"
             *  "Request timed out after: 3000"
             *  "Request Complete!"
             */
            .subscribe(val => console.log(val));
    }
}