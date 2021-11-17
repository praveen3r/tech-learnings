import { interval, timer } from 'rxjs';
import { take, toArray, scan, window, mergeAll, windowCount, tap, windowTime } from 'rxjs/operators';



export class WindowTime {

  //windowTime(windowTimeSpan: number, windowCreationInterval: number, scheduler: Scheduler): Observable

  /*
  An observable of windows, which in turn are Observables.

  It's like bufferTime, but emits a nested Observable instead of an array.

  Returns an Observable that emits windows of items it collects from the source Observable. 
  The output Observable starts a new window periodically, as determined by the windowCreationInterval 
  argument. It emits each window after a fixed timespan, specified by the windowTimeSpan argument. 
  When the source Observable completes or encounters an error, the output Observable emits the 
  current window and propagates the notification from the source Observable. If windowCreationInterval 
  is not provided, the output Observable starts a new window when the previous window of duration 
  windowTimeSpan completes. If maxWindowCount is provided, each window will emit at most fixed number 
  of values. Window will complete immediately after emitting last value and next one still will open 
  as specified by windowTimeSpan and windowCreationInterval arguments.
  */

  //Open new window every specified duration
  static processWindowTime() {
    //emit immediately then every 1s
    const source = timer(0, 1000);
    const example = source.pipe(
      //start new window every 3s
      windowTime(3000),
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
                "NEW WINDOW!"
                3
                4
                5
              */
      )
      .subscribe(val => console.log(val));
  }


}

