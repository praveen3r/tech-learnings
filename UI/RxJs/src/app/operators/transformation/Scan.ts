import { merge, from, Observable, of, Subject, interval } from 'rxjs';
import { map, partition, pluck, reduce, scan, distinctUntilChanged, mergeMap, delay } from 'rxjs/operators';


export class Scan {

    //scan(accumulator: function, seed: any): Observable

    /* An observable of the accumulated values.
    
    It's like reduce, but emits the current accumulation whenever the source emits a value.
    
    Combines together all values emitted on the source, using an accumulator function that knows 
    how to join a new source value into the accumulation from the past. Is similar to reduce, 
    but emits the intermediate accumulations.

    Returns an Observable that applies a specified accumulator function to each item emitted by the 
    source Observable. If a seed value is specified, then that value will be used as the initial value 
    for the accumulator. If no seed value is specified, the first item of the source is used as the 
    seed.


    */


    //Sum over time
    static processScan() {
        const source = of(1, 2, 3);
        // basic scan example, sum over time starting with zero
        const example = source.pipe(scan((acc, curr) => acc + curr, 0));
        // log accumulated values
        // output: 1,3,6
        const subscribe = example.subscribe(val => console.log(val));
    }

    //Accumulating an object
    static processScan1() {
        const subject = new Subject();
        //scan example building an object over time
        const example = subject.pipe(
            scan((acc, curr) => Object.assign({}, acc, curr), {})
        );
        //log accumulated values
        const subscribe = example.subscribe(val =>
            console.log('Accumulated object:', val)
        );
        //next values into subject, adding properties to object
        // {name: 'Joe'}
        subject.next({ name: 'Joe' });
        // {name: 'Joe', age: 30}
        subject.next({ age: 30 });
        // {name: 'Joe', age: 30, favoriteLanguage: 'JavaScript'}
        subject.next({ favoriteLanguage: 'JavaScript' });
    }

    //Emitting random values from the accumulated array.
    static processScan2() {
        // Accumulate values in an array, emit random values from this array.
        /*const scanObs = interval(1000)
            .pipe(
                scan((a, c) => [...a, c], []),
                map(r => r[Math.floor(Math.random() * r.length)]),
                distinctUntilChanged()
            )
            .subscribe(console.log);*/
    }

    //Accumulating http responses over time
    static processScan3() {
        const fakeRequest = of('response').pipe(delay(2000));

        // output:
        // ['response'],
        // ['response','response'],
        // ['response','response','response'],
        // etc...

        interval(1000)
            .pipe(
                mergeMap(_ => fakeRequest),
                scan<string>((all, current) => [...all, current], [])
            )
            .subscribe(console.log);
    }


}

