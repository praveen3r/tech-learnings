import { from, Notification } from 'rxjs';
import { dematerialize } from 'rxjs/operators';

export class Dematerialize {

    //dematerialize(): Observable

    /* An Observable that emits items and notifications embedded in Notification objects emitted 
    by the source Observable.

    Unwraps Notification objects as actual next, error and complete emissions. The opposite of materialize.

    dematerialize is assumed to operate an Observable that only emits Notification objects as next 
    emissions, and does not emit any error. Such Observable is the output of a materialize operation. 
    Those notifications are then unwrapped using the metadata they contain, and emitted as next, error, 
    and complete on the output Observable.

    Use this operator in conjunction with materialize.

    */

    //Delay to recognize long press
    static processDematerialize() {
        //emit next and error notifications
        const source = from([
            Notification.createNext('SUCCESS!'),
            Notification.createError('ERROR!')
        ]).pipe(
            //turn notification objects into notification values
            dematerialize()
        );

        //output: 'NEXT VALUE: SUCCESS' 'ERROR VALUE: 'ERROR!'
        const subscription = source.subscribe({
            next: val => console.log(`NEXT VALUE: ${val}`),
            error: val => console.log(`ERROR VALUE: ${val}`)
        });
    }
}