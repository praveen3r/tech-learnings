import { from, interval, fromEvent } from 'rxjs';
import { map, filter, mapTo } from 'rxjs/operators';

export class MapTo {

    //mapTo(value: any): Observable

    /*
    An Observable that emits the given value every time the source Observable emits something.
    
    Like map, but it maps every source value to the same output value every time.

    Takes a constant value as argument, and emits that whenever the source Observable emits a value. 
    In other words, ignores the actual source value, and simply uses the emission moment to know 
    when to emit the given value.
    */

    //Map every emission to string
    static processMapTo() {

        //emit value every two seconds
        const source = interval(2000);
        //map all emissions to one value
        const example = source.pipe(mapTo('HELLO WORLD!'));
        //output: 'HELLO WORLD!'...'HELLO WORLD!'...'HELLO WORLD!'...
        const subscribe = example.subscribe(val => console.log(val));
    }

    //Mapping clicks to string
    static processMapTo1() {

        //emit every click on document
        const source = fromEvent(document, 'click');
        //map all emissions to one value
        const example = source.pipe(mapTo('GOODBYE WORLD!'));
        //output: (click)'GOODBYE WORLD!'...
        const subscribe = example.subscribe(val => console.log(val));
    }
}