import { interval, timer } from 'rxjs';
import { map, retryWhen, tap, delayWhen } from 'rxjs/operators';

export class RetryWhen {

    //retryWhen(receives: (errors: Observable) => Observable, the: scheduler): Observable 

   static processRetryWhen() {

        //emit value every 1s
        const source = interval(1000);
        const example = source.pipe(
            map(val => {
                if (val > 5) {
                    //error will be picked up by retryWhen
                    throw val;
                }
                return val;
            }),
            retryWhen(errors =>
                errors.pipe(
                    //log error message
                    tap(val => console.log(`Value ${val} was too high!`)),
                    //restart in 6 seconds
                    delayWhen(val => timer(val * 1000))
                )
            )
        );

        /*
            output:
            0
            1
            2
            3
            4
            5
            "Value 6 was too high!"
            --Wait 6 seconds then repeat
        */
        const subscribe = example.subscribe(val => console.log(val));


    }

    
}