import { of, zip, interval } from 'rxjs';
import { mapTo, delay, take, map } from 'rxjs/operators';

export class Zip {

    //zip(observables: *): Observable

    /* Combines multiple Observables to create an Observable whose values are calculated from the 
    values, in order, of each of its input Observables.
    
    If the last parameter is a function, this function is used to compute the created value from the 
    input values. Otherwise, an array of the input values is returned.*/

    static processZip() {

        const sourceOne = of('Hello');
        const sourceTwo = of('World!');
        const sourceThree = of('Goodbye');
        const sourceFour = of('World!');
        //wait until all observables have emitted a value then emit all as an array
        const example = zip(
            sourceOne,
            sourceTwo.pipe(delay(1000)),
            sourceThree.pipe(delay(2000)),
            sourceFour.pipe(delay(3000))
        );
        //output: ["Hello", "World!", "Goodbye", "World!"]
        const subscribe = example.subscribe(val => console.log(val));
    }

    //zip when 1 observable completes
    static processZip1() {
        //emit every 1s
        const source = interval(1000);
        //when one observable completes no more values will be emitted
        const example = zip(source, source.pipe(take(2)));
        //output: [0,0]...[1,1]
        const subscribe = example.subscribe(val => console.log(val));
    }

    //Combine age and name from different sources
    static processZip2() {
        let age$ = of<number>(27, 25, 29);
        let name$ = of<string>('Foo', 'Bar', 'Beer');
        let isDev$ = of<boolean>(true, true, false);

        zip(age$, name$, isDev$).pipe(
            map(([age, name, isDev]) => ({ age, name, isDev })),
        )
            .subscribe(x => console.log(x));

        // outputs
        // { age: 27, name: 'Foo', isDev: true }
        // { age: 25, name: 'Bar', isDev: true }
        // { age: 29, name: 'Beer', isDev: false }
    }
}