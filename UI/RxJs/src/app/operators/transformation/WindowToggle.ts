import { interval, timer } from 'rxjs';
import { take, toArray, scan, window, mergeAll, windowCount, tap, windowTime, windowToggle } from 'rxjs/operators';



export class WindowToggle {

  //windowToggle(openings: Observable, closingSelector: function(value): Observable): Observable

  /*
  An Observable of windows, which are Observables emitting values of the source Observable.

  It's like bufferToggle, but emits a nested Observable instead of an array.

  Returns an Observable that emits windows of items it collects from the source Observable. 
  The output Observable emits windows that contain those items emitted by the source Observable 
  between the time when the openings Observable emits an item and when the Observable returned by 
  closingSelector emits an item.

  */

  //Toggle window at increasing interval
  static processWindowToggle() {
    //emit immediately then every 1s
    const source = timer(0, 1000);
    //toggle window on every 5
    const toggle = interval(5000);
    const example = source.pipe(
      //turn window on every 5s
      windowToggle(toggle, val => interval(val * 1000)),
      tap(_ => console.log('NEW WINDOW!'))
    );

    const subscribeTwo = example
      .pipe(
        //window emits nested observable
        mergeAll()
        /*
                output:
                "NEW WINDOW!"
                5
                "NEW WINDOW!"
                10
                11
                "NEW WINDOW!"
                15
                16
                "NEW WINDOW!"
                20
                21
                22
              */
      )
      .subscribe(val => console.log(val));
  }


}

