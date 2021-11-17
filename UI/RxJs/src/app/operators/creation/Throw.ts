import { throwError, concat, of, interval } from 'rxjs';
import { mergeMap } from 'rxjs/operators';

export class Throw {

    //throw(error: any, scheduler: Scheduler): Observable

    /*
    Creates an Observable that emits no items to the Observer and immediately emits an error notification.
    
    Just emits 'error', and nothing else.
    */
    static processThrow() {

        //emits an error with specified value on subscription
        const source = throwError('This is an error!');
        //output: 'Error: This is an error!'
        const subscribe = source.subscribe({
            next: val => console.log(val),
            complete: () => console.log('Complete!'),
            error: val => console.log(`Error: ${val}`)
        });
    }

    static processThrow1() {

        //emits an error with specified value on subscription
        const source = throwError('This is an error!');
        //output: 'Error: This is an error!'
        const subscribe = source.subscribe({
            next: val => console.log(val),
            complete: () => console.log('Complete!'),
            error: val => console.log(`Error: ${val}`)
        });
    }

    //Emit the number 7, then emit an error
    static processThrow2() {
        interval(1000).pipe(
            mergeMap(x => x === 2
              ? throwError('Twos are bad')
              : of('a', 'b', 'c')
            ),
          ).subscribe(x => console.log(x), e => console.error(e));
           
          // Logs:
          // a
          // b
          // c
          // a
          // b
          // c
          // Twos are bad
    }
}