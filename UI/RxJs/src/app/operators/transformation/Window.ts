import { interval, timer } from 'rxjs';
import { take, toArray, scan, window } from 'rxjs/operators';



export class Window {

    //window(windowBoundaries: Observable): Observable

    /*
    An Observable of windows, which are Observables emitting values of the source Observable.

    It's like buffer, but emits a nested Observable instead of an array.

    Returns an Observable that emits windows of items it collects from the source Observable. 
    The output Observable emits connected, non-overlapping windows. It emits the current window and 
    opens a new one whenever the Observable windowBoundaries emits an item. Because each window is an 
    Observable, the output is a higher-order Observable.

    */

    //Open window specified by inner observable
    static processWindow() {
        //emit immediately then every 1s
        const source = timer(0, 1000);
        const example = source.pipe(window(interval(3000)));
        /*const count = example.pipe(scan((acc, curr) => acc + 1, 0));
        
          "Window 1:"
          0
          1
          2
          "Window 2:"
          3
          4
          5
          ...
        
        const subscribe = count.subscribe(val => console.log(`Window ${val}:`));
        const subscribeTwo = example
            .pipe(mergeAll())
            .subscribe(val => console.log(val));*/
    }


}

