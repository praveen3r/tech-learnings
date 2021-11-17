import { timer } from 'rxjs';

export class Timer {

    static processTimer() {

        /*timer(initialDelay: number | Date, period: number, scheduler: Scheduler): Observable

        After given duration, emit numbers in sequence every specified duration*/

        //emit value in sequence every 1 second after initial delay of 3 seconds
        const source = timer(3000, 1000);
        
        //output: 0,1,2,3,4,5....
        const subscribe = source.subscribe(val => console.log(val));


    }
}
