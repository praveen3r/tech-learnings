import { generate } from 'rxjs';

export class Generate {

    //generate(initialStateOrOptions: GenerateOptions, condition?: ConditionFunc, iterate?: IterateFunc, resultSelectorOrObservable?: (ResultFunc) | SchedulerLike, scheduler?: SchedulerLike): Observable

    /* Creates an Observable that emits no items to the Observer and immediately 
    emits a complete notification.
        
    Just emits 'complete', and nothing else. This static operator is useful for creating a simple
     Observable that only emits the complete notification. It can be used for composing with other 
     Observables, such as in a mergeMap.*/

    //Emit the number 7, then complete
    static processGenerate() {
        generate(2, x => x <= 8, x => x + 3).subscribe(console.log);
​
        /*
        OUTPUT:
        2
        5
        8
        */
    }

    //Generate with result selector
    static processGenerate1() {
        generate(2, x => x <= 38, x => x + 3, x => '.'.repeat(x)).subscribe(
            console.log
          );
          ​
          /*
          OUTPUT:
          ..
          .....
          ........
          ...........
          ..............
          .................
          ....................
          .......................
          ..........................
          .............................
          ................................
          ...................................
          ......................................
          */
    }

}