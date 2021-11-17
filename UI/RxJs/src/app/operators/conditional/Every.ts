import { of, concat } from 'rxjs';
import { every, tap, delay } from 'rxjs/operators';

export class Every {
    // every(predicate: function, thisArg: any): Observable

    /*
    An Observable of booleans that determines if all items of the source Observable meet the 
    condition specified.

    */

    //Some values false
    static processEvery() {
        //emit 5 values
        const source = of(1, 2, 3, 4, 5);
        const example = source.pipe(
            //is every value even?
            every(val => val % 2 === 0)
        );
        //output: false
        const subscribe = example.subscribe(val => console.log(val));
    }

    //Some values false
    static processEvery1() {
        //emit 5 values
        const allEvens = of(2, 4, 6, 8, 10);
        const example = allEvens.pipe(
            //is every value even?
            every(val => val % 2 === 0)
        );
        //output: true
        const subscribe = example.subscribe(val => console.log(val));
    }
    
}

//Values arriving over time and completing stream prematurely due to every returning false
console.clear();
const log = console.log;
const returnCode = request => (Number.isInteger(request) ? 200 : 400);
const fakeRequest = request =>
  of({ code: returnCode(request) }).pipe(
    tap(_ => log(request)),
    delay(1000)
  );

const apiCalls$ = concat(
  fakeRequest(1),
  fakeRequest('invalid payload'),
  fakeRequest(2) //this won't execute as every will return false for previous line
).pipe(
  every(e => e.code === 200),
  tap(e => log(`all request successful: ${e}`))
);

apiCalls$.subscribe();