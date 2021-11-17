import { interval, fromEvent } from 'rxjs';
import { bufferToggle } from 'rxjs/operators';


export class BufferToggle {


    //bufferToggle(openings: Observable, closingSelector: Function): Observable

    /* An Observable of buffers, which are arrays of values.
    
    Collects values from the past as an array. Starts collecting only when opening emits, and calls 
    the closingSelector function to get an Observable that tells when to close the buffer.

   Buffers values from the source by opening the buffer via signals from an Observable provided to 
   openings, and closing and sending the buffers when a Subscribable or Promise returned by the 
   closingSelector function emits.
   */

    //Toggle buffer on and off at interval
    static processBufferToggle() {
        //emit value every second
        const sourceInterval = interval(1000);
        //start first buffer after 5s, and every 5s after
        const startInterval = interval(5000);
        //emit value after 3s, closing corresponding buffer
        const closingInterval = val => {
            console.log(`Value ${val} emitted, starting buffer! Closing in 3s!`);
            return interval(3000);
        };
        //every 5s a new buffer will start, collecting emitted values for 3s then emitting buffered values
        const bufferToggleInterval = sourceInterval.pipe(
            bufferToggle(startInterval, closingInterval)
        );
        //log to console
        //ex. emitted buffers [4,5,6]...[9,10,11]
        const subscribe = bufferToggleInterval.subscribe(val =>
            console.log('Emitted Buffer:', val)
        );
    }

    //Toggle buffer on and off on mouse down/up
    static processBufferToggle1() {
        fromEvent(document, 'mousemove')
            .pipe(
                bufferToggle(fromEvent(document, 'mousedown'), _ =>
                    fromEvent(document, 'mouseup')
                )
            )
            .subscribe(console.log);
    }


}