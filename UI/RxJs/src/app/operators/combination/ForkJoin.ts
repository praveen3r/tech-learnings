import { forkJoin, of, timer, noop, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

export class ForkJoin {

    //forkJoin(...args, selector : function): Observable 

    /*
    Observable emitting either an array of last values emitted by passed Observables or value 
    from project function.

    Wait for Observables to complete and then combine last values they emitted.

    forkJoin is an operator that takes any number of input observables which can be passed either 
    as an array or a dictionary of input observables. If no input observables are provided, resulting 
    stream will complete immediately.

    forkJoin will wait for all passed observables to complete and then it will emit an array or 
    an object with last values from corresponding observables.

    If you pass an array of n observables to the operator, resulting array will have n values, 
    where first value is the last thing emitted by the first observable, second value is the last 
    thing emitted by the second observable and so on.

    If you pass a dictionary of observables to the operator, resulting objects will have the same 
    keys as the dictionary passed, with their last values they've emitted located at the corresponding
    key.

    That means forkJoin will not emit more than once and it will complete after that. If you need 
    to emit combined values not only at the end of lifecycle of passed observables, but also 
    throughout it, try out combineLatest or zip instead.

    In order for resulting array to have the same length as the number of input observables, 
    whenever any of that observables completes without emitting any value, forkJoin will complete 
    at that moment as well and it will not emit anything either, even if it already has some last 
    values from other observables. Conversely, if there is an observable that never completes, 
    forkJoin will never complete as well, unless at any point some other observable completes 
    without emitting value, which brings us back to the previous case. Overall, in order for 
    forkJoin to emit a value, all observables passed as arguments have to emit something at least 
    once and complete.

    If any input observable errors at some point, forkJoin will error as well and all other 
    observables will be immediately unsubscribed.

    Optionally forkJoin accepts project function, that will be called with values which normally 
    would land in emitted array. Whatever is returned by project function, will appear in output 
    observable instead. This means that default project can be thought of as a function that takes 
    all its arguments and puts them into an array. Note that project function will be called only 
    when output observable is supposed to emit a result.

    */
    static processForkJoin() {

        const observable1 = of(1, 2, 3, 4);
        const observable2 = Promise.resolve(8);
        const observable3 = timer(4000);

        const observable = forkJoin(observable1,observable2, observable3);

            observable.subscribe({
             next: value => console.log(value),
             complete: () => console.log('This is how it ends!'),
            });
             
            // Logs:
            // { foo: 4, bar: 8, baz: 0 } after 4 seconds
            // "This is how it ends!" immediately after
            
    }

    static processForkJoinWithResult() {

        const observable1 = of(1, 2, 3, 4);
        const observable2 = Promise.resolve(8);
        const observable3 = timer(4000);

        const observable = forkJoin(observable1,observable2, observable3);

            observable.subscribe(([res1, res2, res3]) => {
              console.log(`res1 is ${res1} and res2 is ${res2} and res3 is ${res3}`),
              noop,
             console.log('This is how it ends!')
            });
            
    }

    //NO Hanlding 
    static processForkJoinWithError() {

        const observable1 = of(1, 2, 3, 4);
        const observable2 = Promise.resolve(8);
        const observable3 = throwError('This will error');

        const observable = forkJoin(observable1,observable2, observable3);

        //output: 'This will Error'
        const subscribe = observable.subscribe(val => console.log(val), 
                                                () => console.log("error"),
                                                () => console.log("completed"));

    }

    //Hanlding outside
    static processForkJoinWithError1() {

        const observable1 = of(1, 2, 3, 4);
        const observable2 = Promise.resolve(8);
        const observable3 = throwError('This will error');

        const observable = forkJoin(observable1,observable2, observable3)
                            .pipe(catchError(error => of(error)));

        //output: 'This will Error'
        const subscribe = observable.subscribe(val => console.log(val));

    }

    //Hanlding inside
    static processForkJoinWithError2() {

        const observable1 = of(1, 2, 3, 4);
        const observable2 = Promise.resolve(8);
        const observable3 = throwError('This will error').pipe(catchError(error => of(error)));

        const observable = forkJoin(observable1,observable2, observable3);

        //output: ["Hello", "World", "This will error"]
        const subscribe = observable.subscribe(val => console.log(val));

    }
}