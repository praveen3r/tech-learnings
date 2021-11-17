import { interval, timer } from 'rxjs';
import { take, toArray, scan, window, mergeAll, windowCount, tap } from 'rxjs/operators';



export class WindowCount {

  //windowCount(windowSize: number, startWindowEvery: number): Observable

  /*
  An Observable of windows, which in turn are Observable of values.

 It's like bufferCount, but emits a nested Observable instead of an array.

  Returns an Observable that emits windows of items it collects from the source Observable. 
  The output Observable emits windows every startWindowEvery items, each containing no more than 
  windowSize items. When the source Observable completes or encounters an error, the output Observable 
  emits the current window and propagates the notification from the source Observable. If 
  startWindowEvery is not provided, then new windows are started immediately at the start of the source 
  and when each window completes with size windowSize.

  */

  //Start new window every x items emitted
  static processWindowCount() {
    //emit every 1s
    const source = interval(1000);
    const example = source.pipe(
      //start new window every 4 emitted values
      windowCount(4),
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
                "NEW WINDOW!"
                4
                5
                6
                7
              */
      )
      .subscribe(val => console.log(val));
  }


}

