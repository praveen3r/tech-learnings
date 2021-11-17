import { of, merge, interval } from 'rxjs';
import { take, delay, exhaustMap, expand } from 'rxjs/operators';

export class Expand {

    //expand(project: function, concurrent: number, scheduler: Scheduler): Observable

    /* An Observable that emits the source values and also result of applying the projection 
        function to each value emitted on the output Observable and and merging the results of the 
        Observables obtained from this transformation. 
    
    It's similar to mergeMap, but applies the projection function to every source value as well as every output value.
     It's recursive.
    
    Returns an Observable that emits items based on applying a function that you supply to each item
     emitted by the source Observable, where that function returns an Observable, and then merging 
     those resulting Observables and emitting the results of this merger. Expand will re-emit on the 
     output Observable every source value. Then, each output value is given to the project function 
     which returns an inner Observable to be merged on the output Observable. Those output values 
     resulting from the projection are also given to the project function to produce new output values.
      This is how expand behaves recursively.*/

    static processExpand() {

        //emit 2
        const source = of(2);
        const example = source.pipe(
            //recursively call supplied function
            expand(val => {
                //2,3,4,5,6
                console.log(`Passed value: ${val}`);
                //3,4,5,6
                return of(1 + val);
            }),
            //call 5 times
            take(5)
        );
        /*
            "RESULT: 2"
            "Passed value: 2"
            "RESULT: 3"
            "Passed value: 3"
            "RESULT: 4"
            "Passed value: 4"
            "RESULT: 5"
            "Passed value: 5"
            "RESULT: 6"
            "Passed value: 6"
        */
        //output: 2,3,4,5,6
        const subscribe = example.subscribe(val => console.log(`RESULT: ${val}`));
    }

    //Another exhaustMap with interval
    static processExpand1() {
        const firstInterval = interval(1000).pipe(take(10));
        const secondInterval = interval(1000).pipe(take(2));

        const exhaustSub = firstInterval
            .pipe(
                exhaustMap(f => {
                    console.log(`Emission Corrected of first interval: ${f}`);
                    return secondInterval;
                })
            )
            /*
            When we subscribed to the first interval, it starts to emit a values (starting 0).
            This value is mapped to the second interval which then begins to emit (starting 0).  
            While the second interval is active, values from the first interval are ignored.
            We can see this when firstInterval emits number 3,6, and so on...

            Output:
            Emission of first interval: 0
            0
            1
            Emission of first interval: 3
            0
            1
            Emission of first interval: 6
            0
            1
            Emission of first interval: 9
            0
            1
        */
            .subscribe(s => console.log(s));
    }
}