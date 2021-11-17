import { race, interval } from 'rxjs';
import { mapTo } from 'rxjs/operators';

export class Race {

    //race(): Observable

    /* An Observable that mirrors the output of the first Observable to emit an item.
    
    Puts the current value and previous value together as an array, and emits that.*/
    static processRace() {

        //take the first observable to emit
        const example = race(
            //emit every 1.5s
            interval(1500),
            //emit every 1s
            //interval(1000).pipe(mapTo('1s won!')),
            //emit every 2s
            interval(2000),
            //emit every 2.5s
            interval(2500)
        );
        
        const subscribe = example.subscribe(console.log);
    }

    

}