import { range } from 'rxjs';

export class Range {

    //Creates an Observable that emits a sequence of numbers within a specified range.

    static processRange() {

        //emit 1-10 in sequence
        const source = range(1, 10);

        //output: 1,2,3,4,5,6,7,8,9,10
        const example = source.subscribe(val => console.log(val));
    }
}