import { of } from 'rxjs';

export class Of {

    //of(...values, scheduler: Scheduler): Observable

    /* Emit variable amount of values in a sequence and then emits a complete notification. */

    //Emitting a sequence of numbers
    static processOf() {

        //emits any number of provided values in sequence
        const source = of(1, 2, 3, 4, 5);
        
        //output: 1,2,3,4,5
        const subscribe = source.subscribe(val => console.log(val));
    }

    static processOf1() {

        //emits values of any type
        const source = of({ name: 'Brian' }, [1, 2, 3], function hello() {
            return 'Hello';
        });

        //output: {name: 'Brian'}, [1,2,3], function hello() { return 'Hello' }
        const subscribe = source.subscribe(val => console.log(val));
    }
}