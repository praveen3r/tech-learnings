import { interval, timer } from 'rxjs';
import { take, toArray, scan, window, mergeAll, windowCount, tap, windowTime, windowToggle, windowWhen } from 'rxjs/operators';



export class WindowWhen {

  //windowWhen(closingSelector: function(): Observable): Observable

  /*
  An Observable of windows, which are Observables emitting values of the source Observable.

  It's like bufferWhen, but emits a nested Observable instead of an array.

  Returns an Observable that emits windows of items it collects from the source Observable. 
  The output Observable emits connected, non-overlapping windows. It emits the current window and 
  opens a new one whenever the Observable produced by the specified closingSelector function emits 
  an item. The first window is opened immediately when subscribing to the output Observable.

  */

  //Open and close window at interval
  static processWindowWhen() {
    //emit immediately then every 1s
    const source = timer(0, 1000);
    const example = source.pipe(
      //close window every 5s and emit observable of collected values from source
      windowWhen(() => interval(5000)),
      tap(_ => console.log('NEW WINDOW!'))
    );

    const subscribeTwo = example
      .pipe(
        //window emits nested observable
        mergeAll()
        /*
          output:
          "NEW WINDOW!"
          0
          1
          2
          3
          4
          "NEW WINDOW!"
          5
          6
          7
          8
          9
        */
      )
      .subscribe(val => console.log(val));
  }


}

