import { interval } from 'rxjs';
import { bufferWhen } from 'rxjs/operators';



export class BufferWhen {


    //bufferToggle(openings: Observable, closingSelector: Function): Observable

    /* An Observable of buffers, which are arrays of values.
    
    Collects values from the past as an array. When it starts collecting values, it calls a 
    function that returns an Observable that tells when to close the buffer and restart collecting.

   Opens a buffer immediately, then closes the buffer when the observable returned by calling 
   closingSelector function emits a value. When it closes the buffer, it immediately opens a 
   new buffer and repeats the process.
   */

    //Toggle buffer on and off at interval
    static processBufferWhen() {
        //emit value every 1 second
        const oneSecondInterval = interval(1000);
        //return an observable that emits value every 5 seconds
        const fiveSecondInterval = () => interval(5000);
        //every five seconds, emit buffered values
        const bufferWhenExample = oneSecondInterval.pipe(
            bufferWhen(fiveSecondInterval)
        );
        //log values
        //ex. output: [0,1,2,3]...[4,5,6,7,8]
        const subscribe = bufferWhenExample.subscribe(val =>
            console.log('Emitted Buffer: ', val)
        );
    }

}