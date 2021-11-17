import { of, Observable, from, interval } from 'rxjs';
import { concatMap, map, delay, mergeMap, take, concatMapTo } from 'rxjs/operators';

export class ConcatMapTo {


    //concatMapTo(observable: Observable, resultSelector: function): Observable 

    /* An observable of values merged together by joining the passed observable with itself, 
        one after the other, for each value emitted from the source.
    
        It's like concatMap, but maps each value always to the same inner Observable.
    
    Maps each source value to the given Observable innerObservable regardless of the source value, 
    and then flattens those resulting Observables into one single Observable, which is the output 
    Observable. Each new innerObservable instance emitted on the output Observable is concatenated 
    with the previous innerObservable instance.

    Warning: if source values arrive endlessly and faster than their corresponding inner Observables 
    can complete, it will result in memory issues as inner Observables amass in an unbounded buffer 
    waiting for their turn to be subscribed to.

    Note: concatMapTo is equivalent to mergeMapTo with concurrency parameter set to 1.
    */

    //Map to basic observable (simulating request)
    static processConcatMapTo() {

        //emit value every 2 seconds
        const sampleInterval = interval(500).pipe(take(5));
        const fakeRequest = of('Network request complete').pipe(delay(3000));
        //wait for first to complete before next is subscribed
        const example = sampleInterval.pipe(concatMapTo(fakeRequest));
        //result
        //output: Network request complete...3s...Network request complete'
        const subscribe = example.subscribe(val => console.log(val));

    }

    //Supplying a projection function
    static processConcatMapTo1() {
        //emit value every 2 seconds
        const interval$ = interval(2000);
        //emit value every second for 5 seconds
        const source = interval(1000).pipe(take(5));
        /*
          ***Be Careful***: In situations like this where the source emits at a faster pace
          than the inner observable completes, memory issues can arise.
          (interval emits every 1 second, basicTimer completes every 5)
        */
        // basicTimer will complete after 5 seconds, emitting 0,1,2,3,4
        const example = interval$.pipe(
            concatMapTo(
                source,
                (firstInterval, secondInterval) => `${firstInterval} ${secondInterval}`
            )
        );
        /*
          output: 0 0
                  0 1
                  0 2
                  0 3
                  0 4
                  1 0
                  1 1
                  continued...
        
        */
        const subscribe = example.subscribe(val => console.log(val));
    }




}

