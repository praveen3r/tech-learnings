import { fromEvent, interval, of } from 'rxjs';
import { bufferCount, tap, map, mergeMap, bufferTime } from 'rxjs/operators';

export class BufferTime {


    //bufferTime(bufferTimeSpan: number, bufferCreationInterval: number, scheduler: Scheduler): Observable

    /* An Observable of buffers, which are arrays of values.
    
    Collects values from the past as an array, and emits those arrays periodically in time.

   Buffers values from the source for a specific time duration bufferTimeSpan. 
   Unless the optional argument bufferCreationInterval is given, it emits and resets the buffer
    every bufferTimeSpan milliseconds. If bufferCreationInterval is given, this operator opens 
    the buffer every bufferCreationInterval milliseconds and closes (emits and resets) the buffer 
    every bufferTimeSpan milliseconds. When the optional argument maxBufferSize is specified, 
    the buffer will be closed either after bufferTimeSpan milliseconds or when it contains 
    maxBufferSize elements.
   */

    //Buffer for 2 seconds
    static processBufferTime() {
        //Create an observable that emits a value every 500ms
        const source = interval(500);
        //After 2 seconds have passed, emit buffered values as an array
        const example = source.pipe(bufferTime(2000));
        //Print values to console
        //ex. output [0,1,2]...[3,4,5,6]
        const subscribe = example.subscribe(val =>
            console.log('Buffered with Time:', val)
        );
    }

    //multiple active buffers
    static processBufferTime1() {
        //Create an observable that emits a value every 500ms
        const source = interval(500);
        /*
        bufferTime also takes second argument, when to start the next buffer (time in ms)
        for instance, if we have a bufferTime of 2 seconds but second argument (bufferCreationInterval) of 1 second:
        ex. output: [0,1,2]...[1,2,3,4,5]...[3,4,5,6,7]
        */
        const example = source.pipe(bufferTime(2000, 1000));
        //Print values to console
        const subscribe = example.subscribe(val =>
            console.log('Start Buffer Every 1s:', val)
        );
    }

    
}