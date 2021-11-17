import { interval } from 'rxjs';

export class Interval {


    static processInterval() {

        /* interval(period: number, scheduler: Scheduler): Observable 
        
        Emit numbers in sequence based on provided timeframe. */

        //emit value in sequence every 1 second
        const source = interval(1000);
        
        //output: 0,1,2,3,4,5....
        const subscribe = source.subscribe(val => console.log(val));

        const subscribe1 = source.subscribe(val => console.log(`Stream 2 ${val}`));
    }
}
