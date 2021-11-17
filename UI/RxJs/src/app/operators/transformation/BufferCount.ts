import { fromEvent, interval, of } from 'rxjs';
import { buffer, throttleTime, filter, bufferCount, tap, map, mergeMap } from 'rxjs/operators';

export class BufferCount {


    //bufferCount(bufferSize: number, startBufferEvery: number = null): Observable

    /* An Observable of buffers, which are arrays of values.
    
    Collects values from the past as an array, and emits that array only when its size reaches bufferSize.

   Buffers a number of values from the source Observable by bufferSize then emits the buffer and 
   clears it, and starts a new buffer each startBufferEvery values. If startBufferEvery is not 
   provided or is null, then new buffers are started immediately at the start of the source and 
   when each buffer closes and is emitted.
   */

    //Using buffer to recognize double clicks
    static processBufferCount() {
        //Create an observable that emits a value every second
        const source = interval(1000);
        //After three values are emitted, pass on as an array of buffered values
        const bufferThree = source.pipe(bufferCount(3));
        //Print values to console
        //ex. output [0,1,2]...[3,4,5]
        const subscribe = bufferThree.subscribe(val =>
            console.log('Buffered Values:', val)
        );
    }

    //Overlapping buffers
    static processBufferCount1() {
        //Create an observable that emits a value every second
        const source = interval(1000);
        /*
        bufferCount also takes second argument, when to start the next buffer
        for instance, if we have a bufferCount of 3 but second argument (startBufferEvery) of 1:
        1st interval value:
        buffer 1: [0]
        2nd interval value:
        buffer 1: [0,1]
        buffer 2: [1]
        3rd interval value:
        buffer 1: [0,1,2] Buffer of 3, emit buffer
        buffer 2: [1,2]
        buffer 3: [2]
        4th interval value:
        buffer 2: [1,2,3] Buffer of 3, emit buffer
        buffer 3: [2, 3]
        buffer 4: [3]
        */
        const bufferEveryOne = source.pipe(bufferCount(3, 1));
        //Print values to console
        const subscribe = bufferEveryOne.subscribe(val =>
            console.log('Start Buffer Every 1:', val)
        );
    }

    //Last n keyboard presses tracking
    static processBufferCount2() {
        const fakeKeyPressesPost = keypresses =>
            of(201).pipe(
                tap(_ => {
                    console.log(`received key presses are: ${keypresses}`);
                    document.getElementById('output').innerText = keypresses;
                })
            );

        fromEvent(document, 'keydown')
            .pipe(
                map((e: KeyboardEvent) => e.key),
                bufferCount(5),
                mergeMap(fakeKeyPressesPost)
            )
            .subscribe();
    }
}