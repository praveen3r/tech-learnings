import { of } from 'rxjs';
import { map, catchError, take } from 'rxjs/operators';

export class CatchError {

    //catchError(project : function): Observable 

    /* An observable that originates from either the source or the observable returned 
    by the catch selector function. */

    static processCatchError() {

       const source = of(1, 2, 3, 4, 5);
       
       // Continues with a different Observable when there's an error
       const result = source.pipe(map(n => {
            if (n === 4) {
                throw 'four!';
            }
             return n;
            }),
            catchError(err => of('I', 'II', 'III', 'IV', 'V')),
            );
           
            // output 1, 2, 3, I, II, III, IV, V
            result.subscribe(x => console.log(x));
            
            
    }

    static processCatchError1() {

        const source = of(1, 2, 3, 4, 5);
        
        // Retries the caught source Observable again in case of error, similar to retry() operator
        const result = source.pipe(map(n => {
             if (n === 4) {
                 throw 'four!';
             }
              return n;
             }),
             catchError((err, caught) => caught),
             take(30),

             );
            
             // output 1, 2, 3, 1, 2, 3, ...
             result.subscribe(x => console.log(x));
             
             
     }

     static processCatchError2() {

        const source = of(1, 2, 3, 4, 5);
        
        // Throws a new error when the source Observable throws an error
        const result = source.pipe(map(n => {
             if (n === 4) {
                 throw 'four!';
             }
              return n;
             }),
             catchError(err => {
                throw 'error in source. Details: ' + err;
                }),
                
             );
            
             // output 1, 2, 3, error in source. Details: four!
             result.subscribe(x => console.log(x),
                                err => console.log(err)
             );
             
             
     }
}