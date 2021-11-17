import { from, interval, zip, merge, fromEvent } from 'rxjs';
import { last, sample, mapTo } from 'rxjs/operators';

export class Sample {

    // sample(sampler: Observable): Observable

    /* An Observable that emits the results of sampling the values emitted by the source 
        Observable whenever the notifier Observable emits value or completes.

        It's like sampleTime, but samples whenever the notifier Observable emits something.

        Whenever the notifier Observable emits a value or completes, sample looks at the source 
        Observable and emits whichever value it has most recently emitted since the previous sampling, 
        unless the source has not emitted anything since the previous sampling. 
        The notifier is subscribed to as soon as the output Observable is subscribed.

      */

    //Sample source every 2 seconds
    static processSample() {

        //emit value every 1s
        const source = interval(1000);
        //sample last emitted value from source every 2s
        const example = source.pipe(sample(interval(2000)));
        //output: 2..4..6..8..
        const subscribe = example.subscribe(val => console.log(val));

    }

    //Sample source when interval emits
    static processSample1() {

        const source = zip(
            //emit 'Joe', 'Frank' and 'Bob' in sequence
            from(['Joe', 'Frank', 'Bob']),
            //emit value every 2s
            interval(2000)
        );
        //sample last emitted value from source every 2.5s
        const example = source.pipe(sample(interval(2500)));
        //output: ["Joe", 0]...["Frank", 1]...........
        const subscribe = example.subscribe(val => console.log(val));


    }

    // Distinguish between drag and click
    static processLast2() {

        const listener = merge(
            fromEvent(document, 'mousedown').pipe(mapTo(false)),
            fromEvent(document, 'mousemove').pipe(mapTo(true))
        )
        .pipe(sample(fromEvent(document, 'mouseup')))
        .subscribe(isDragging => {
            console.log('Were you dragging?', isDragging);
        });
    }
}