import { timer, combineLatest, of } from 'rxjs';
import { delay, startWith } from 'rxjs/operators';

export class CombineLatest {

    // An Observable of projected values from the most recent values from each input Observable, or an array of the most recent values from each input Observable.

    /*
    combineLatest combines the values from all the Observables passed as arguments. 
    This is done by subscribing to each Observable in order and, whenever any Observable emits, 
    collecting an array of the most recent values from each Observable. So if you pass n Observables 
    to operator, returned Observable will always emit an array of n values, in order corresponding 
    to order of passed Observables (value from the first Observable on the first place and so on).

    Static version of combineLatest accepts either an array of Observables or each Observable 
    can be put directly as an argument. Note that array of Observables is good choice, if you don't 
    know beforehand how many Observables you will combine. Passing empty array will result in Observable
     that completes immediately.

    To ensure output array has always the same length, combineLatest will actually wait for all 
    input Observables to emit at least once, before it starts emitting results. This means if some 
    Observable emits values before other Observables started emitting, all these values but the last 
    will be lost. On the other hand, if some Observable does not emit a value but completes, 
    resulting Observable will complete at the same moment without emitting anything, since it will 
    be now impossible to include value from completed Observable in resulting array. Also, if some
     input Observable does not emit any value and never completes, combineLatest will also never 
     emit and never complete, since, again, it will wait for all streams to emit some value.

    If at least one Observable was passed to combineLatest and all passed Observables emitted
    something, resulting Observable will complete when all combined streams complete. So even if
    some Observable completes, result of combineLatest will still emit values when other Observables
    do. In case of completed Observable, its value from now on will always be the last emitted value.
    On the other hand, if any Observable errors, combineLatest will error immediately as well, 
    and all other Observables will be unsubscribed.

    combineLatest accepts as optional parameter project function, which takes as arguments all values
     that would normally be emitted by resulting Observable. project can return any kind of value, 
     which will be then emitted by Observable instead of default array. Note that project does not 
     take as argument that array of values, but values themselves. That means default project can be 
     imagined as function that takes all its arguments and puts them into an array.

    */
    static processCombineLatest() {
        const firstTimer = timer(0, 1000); // emit 0, 1, 2... after every second, starting from now
        const secondTimer = timer(500, 1000); // emit 0, 1, 2... after every second, starting 0,5s from now
        const combinedTimers = combineLatest(firstTimer, secondTimer);
        combinedTimers.subscribe(value => console.log(value));
        // Logs
        // [0, 0] after 0.5s
        // [1, 0] after 1s
        // [1, 1] after 1.5s
        // [2, 1] after 2s
    }

    static processCombineLatest1() {

        // timerOne emits first value at 1s, then once every 4s
        const timerOne$ = timer(1000, 4000);
        // timerTwo emits first value at 2s, then once every 4s
        const timerTwo$ = timer(2000, 4000);
        // timerThree emits first value at 3s, then once every 4s
        const timerThree$ = timer(3000, 4000);

        // when one timer emits, emit the latest values from each timer as an array
        combineLatest(timerOne$, timerTwo$, timerThree$).subscribe(
            ([timerValOne, timerValTwo, timerValThree]) => {
                /*
                  Example:
                timerThree first tick: 'Timer One Latest: 0, Timer Two Latest: 0, Timer Three Latest: 0
                timerOne second tick: 'Timer One Latest: 1, Timer Two Latest: 0, Timer Three Latest: 0
                timerTwo second tick: 'Timer One Latest: 1, Timer Two Latest: 1, Timer Three Latest: 0
              */
                console.log(
                    `Timer One Latest: ${timerValOne},
                    Timer Two Latest: ${timerValTwo},
                    Timer Three Latest: ${timerValThree}`
                );
            });
    }

    //combineLatest with projection function
    static processCombineLatest2() {

        const timerOne$ = timer(1000, 4000);
        const timerTwo$ = timer(2000, 4000);
        const timerThree$ = timer(3000, 4000);

        combineLatest(
            timerOne$,
            timerTwo$,
            timerThree$,
            // combineLatest also takes an optional projection function
            (one, two, three) => {
                return `Timer One (Proj) Latest: ${one}, 
              Timer Two (Proj) Latest: ${two}, 
              Timer Three (Proj) Latest: ${three}`;
            }
        ).subscribe(console.log);
    }

    static processCombineLatest3() {
        const observables = [1, 5, 10].map(
            n => of(n).pipe(
              delay(n * 1000),   // emit 0 and then emit n after n seconds
              startWith(0),
            )
          );
          const combined = combineLatest(observables);
          combined.subscribe(value => console.log(value));
          // Logs
          // [0, 0, 0] immediately
          // [1, 0, 0] after 1s
          // [1, 5, 0] after 5s
          // [1, 5, 10] after 10s
    }
}